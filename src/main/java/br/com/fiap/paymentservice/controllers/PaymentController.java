package br.com.fiap.paymentservice.controllers;

import br.com.fiap.paymentservice.bean.Payment;
import br.com.fiap.paymentservice.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@Api(value = "Payment", description = "Payment Controller REST API")
public class PaymentController {

    private PaymentService service;

    public PaymentController() {
        this.service = new PaymentService();
    }

   
    @ApiOperation(httpMethod = "POST", value = "Create new payment")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns created payment", response = Payment.class)
    })
    @PostMapping("/save")
    public ResponseEntity<Object> savePayment(@RequestBody Payment payment){
        Payment savePayment = this.service.save(payment);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/findById/{id}")
                .buildAndExpand(savePayment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(httpMethod = "PATCH", value = "Update payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns success message")
    })
    @PatchMapping("/update")
    public ResponseEntity updatePayment(@RequestBody Payment payment){
        if (!this.service.update(payment))
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "DELETE", value = "Delete payment by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retuns success message")
    })
    @DeleteMapping("/payment/{id}")
    public ResponseEntity deletePayment(@PathVariable("id") int id){
        if (this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
    @ApiOperation(httpMethod = "GET", value = "Get payment by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns payment object", response = Payment.class)
    })
    @GetMapping("/findById/{id}")
    public ResponseEntity<Payment> find(@PathVariable("id") int id){
        Payment payment = this.service.findById(id);
        if (payment == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
