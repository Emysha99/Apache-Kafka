package com.ecommerce.payment_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "paymentTable")
public class Payment {
    @Id
    private Long orderId;
    private String payMethod;
    private String status="Pending";
}
