package com.springboot.demo.SpringWebAPI.service;


import com.springboot.demo.SpringWebAPI.entity.Payment;
import com.springboot.demo.SpringWebAPI.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());
        return paymentRepository.save(payment);
    }


    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByBookingId(Long bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
