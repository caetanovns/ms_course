package br.com.msfood.payments.controller;

import br.com.msfood.payments.dto.PaymentDto;
import br.com.msfood.payments.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public Page<PaymentDto> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return paymentService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findOne(@PathVariable @NotNull Long id) {
        PaymentDto dto = paymentService.readOne(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> create(@RequestBody @Valid PaymentDto dto, UriComponentsBuilder uriComponentsBuilder) {
        PaymentDto paymentDto = paymentService.create(dto);
        URI address = uriComponentsBuilder.path("/payments/{id}").buildAndExpand(paymentDto.getId()).toUri();
        return ResponseEntity.created(address).body(paymentDto);
    }
}
