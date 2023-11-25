package br.com.msfood.payments.service;

import br.com.msfood.payments.dto.PaymentDto;
import br.com.msfood.payments.models.Payment;
import br.com.msfood.payments.models.Status;
import br.com.msfood.payments.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PaymentDto> readAll(Pageable pageable) {
        return repository.findAll(pageable).map(p -> modelMapper.map(p, PaymentDto.class));
    }

    public PaymentDto readOne(Long id) {
        Payment payment = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return this.modelMapper.map(payment, PaymentDto.class);
    }

    public PaymentDto create(PaymentDto paymentRecord) {
        Payment payment = this.modelMapper.map(paymentRecord, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);
        return modelMapper.map(payment, PaymentDto.class);
    }
}
