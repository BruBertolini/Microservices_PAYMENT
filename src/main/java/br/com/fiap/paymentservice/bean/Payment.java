package br.com.fiap.paymentservice.bean;

import lombok.*;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
    @ApiModelProperty(notes = "Payment ID")
    private int id;
	
    @ApiModelProperty(notes = "Card number", required="true")
    private String cardNumber;
	
    @ApiModelProperty(notes = "Card expiration date", required="true")
    private String expireDate;
	
    @ApiModelProperty(notes = "Card operator (Visa, Master, etc)", required="true")
    private String operator;
	 
    @ApiModelProperty(notes = "Total amount to charge", required="true")
    private BigDecimal totalValue;

    public Payment(int id) { this.id = id; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
   
}
