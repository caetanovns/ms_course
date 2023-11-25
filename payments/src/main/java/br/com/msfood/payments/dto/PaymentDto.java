package br.com.msfood.payments.dto;

import br.com.msfood.payments.models.Payment;
import br.com.msfood.payments.models.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {
    private Long id;
    private BigDecimal price;
    private String name;
    private String number;
    private String expiration;
    private String cvv;
    private Status status;
    private Long orderId;
    private Long paymentMethodId;

}
