package br.com.fiap.paymentservice.controllers;

import br.com.fiap.paymentservice.bean.Payment;
import br.com.fiap.paymentservice.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
public class PaymentController {

    private PaymentService service;

    public PaymentController() {
        this.service = new PaymentService();
    }

   

    @PostMapping("/save")
    public ResponseEntity<Object> savePayment(@RequestBody Payment payment){
        Payment savePayment = this.service.save(payment);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/findById/{id}")
                .buildAndExpand(savePayment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/update")
    public ResponseEntity updatePayment(@RequestBody Payment payment){
        if (!this.service.update(payment))
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity deletePayment(@PathVariable("id") int id){
        if (this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Payment> find(@PathVariable("id") int id){
        Payment payment = this.service.findById(id);
        if (payment == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}