package com.ecommerce.payment_service.service;

import com.ecommerce.payment_service.dto.request.PaymentRequest;
import com.ecommerce.payment_service.dto.response.PaymentResponse;
import com.ecommerce.payment_service.model.Payment;
import com.ecommerce.payment_service.repository.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    Payment rootPayment=new Payment();
    final ObjectMapper mapper = new ObjectMapper();

    public void createPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment(
                paymentRequest.getOrderId(),
                paymentRequest.getPayMethod(),
                rootPayment.getStatus()
        );
        paymentRepository.save(payment);

    }

    //get payment by order Id
    public PaymentResponse getPaymentByOrderId (Long orderId) {
        Payment payment = paymentRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + orderId));
        return convertToDTO(payment);
    }

    private PaymentResponse convertToDTO(Payment payment) {
        return new PaymentResponse(
                payment.getOrderId(),
                payment.getPayMethod(),
                payment.getStatus());
    }
}
