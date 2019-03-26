package br.com.fiap.paymentservice.bean;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private int id;
    private String cardNumber;
    private String expireDate;
    private String operator;
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
