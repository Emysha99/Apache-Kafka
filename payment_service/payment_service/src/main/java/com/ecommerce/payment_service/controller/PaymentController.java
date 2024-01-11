package com.ecommerce.payment_service.controller;


import com.ecommerce.payment_service.dto.request.PaymentRequest;
import com.ecommerce.payment_service.dto.response.PaymentResponse;
import com.ecommerce.payment_service.model.Payment;
import com.ecommerce.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //create payment
    @PostMapping("payment")
    public String createPayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.createPayment(paymentRequest);
        return "Payment created successfully";
    }

    //get payment by orderid
    @GetMapping("/{orderId}")
    public PaymentResponse getPaymentByOrderId(@PathVariable Long orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }

}
