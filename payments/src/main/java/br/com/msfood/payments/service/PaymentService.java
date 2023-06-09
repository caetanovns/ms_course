package br.com.msfood.payments.service;

import br.com.msfood.payments.models.Payment;
import br.com.msfood.payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Page<Payment> readAll(Pageable pageable){
        return repository.findAll(pageable);
    }
}
