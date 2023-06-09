package br.com.msfood.payments.repository;

import br.com.msfood.payments.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
