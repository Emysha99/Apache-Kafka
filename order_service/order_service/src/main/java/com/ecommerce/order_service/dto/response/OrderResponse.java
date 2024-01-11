package com.ecommerce.order_service.dto.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    @Id
    private Long orderId;
    private String item;
    private Double quantity;
    private BigDecimal value;
}
