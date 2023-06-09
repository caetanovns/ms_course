package br.com.msfood.payments.dto;

import br.com.msfood.payments.models.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PaymentRecord(
        Long id,
        BigDecimal price,
        String name,
        String number,
        String expiration,
        String cvv,
        Status status,
        Long orderId,
        Long paymentMethodId
) {
}
