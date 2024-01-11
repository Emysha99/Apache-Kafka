package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.request.OrderRequest;
import com.ecommerce.order_service.dto.response.OrderResponse;
import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    Order rootOrder=new Order();
    final ObjectMapper mapper = new ObjectMapper();

    public void createOrder(OrderRequest orderRequest) {

        Order order = new Order(
                rootOrder.getOrderId(),
                orderRequest.getItem(),
                orderRequest.getQuantity(),
                orderRequest.getValue()
        );
        orderRepository.save(order);

    }
    public  List<OrderResponse> getAllOrders() {
        List<Order> orders =orderRepository.findAll();
        return orders.stream().map(this::convertToDTO).toList();
    }

    private OrderResponse convertToDTO(Order order) {
        // Convert Order entity to OrderDTO
        return new OrderResponse(
                order.getOrderId(),
                order.getItem(),
                order.getQuantity(),
                order.getValue());
    }

    //get order by order Id
    public OrderResponse getOrderById (Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
        return convertToDTO(order);
    }

    //delete order by order Id
    public void deleteOrder(Long orderId) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));

        orderRepository.delete(existingOrder);
    }

   //update order by order Id
   public void updateOrder(Long orderId, OrderRequest updatedOrder) {
       Order existingOrder = orderRepository.findById(orderId)
               .orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));

       existingOrder.setItem(updatedOrder.getItem());
       existingOrder.setQuantity(updatedOrder.getQuantity());
       existingOrder.setValue(updatedOrder.getValue());
       orderRepository.save(existingOrder);
   }
}
