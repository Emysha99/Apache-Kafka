package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.request.OrderRequest;
import com.ecommerce.order_service.dto.response.OrderResponse;
import com.ecommerce.order_service.repository.OrderRepository;
import com.ecommerce.order_service.service.OrderService;
import com.ecommerce.order_service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class orderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private  Order order;

    //create product
    @PostMapping("order")
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
        return "Order Created successfully";
    }

    //get all orderInfo
    @GetMapping("/allOrders")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    //get order by orderID
    @GetMapping("/{orderId}")
    public OrderResponse getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    //delete order by order Id
    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "Order deleted successfully!";
    }

    //update order by order Id
    @PutMapping("/{orderId}")
    public String updateOrder(@PathVariable Long orderId, @RequestBody OrderRequest updatedOrder) {
        orderService.updateOrder(orderId, updatedOrder);
        return "Product updated successfully!";
    }


}
