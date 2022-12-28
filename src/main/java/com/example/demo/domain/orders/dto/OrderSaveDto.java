package com.example.demo.domain.orders.dto;

import com.example.demo.domain.orders.Delivery;
import com.example.demo.domain.orders.Order;
import com.example.demo.domain.orders.OrderItem;
import com.example.demo.domain.orders.OrderStatus;
import com.example.demo.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderSaveDto {

    private User user;
    private List<OrderItem> orderItems;
    private Delivery delivery;
    private OrderStatus orderStatus;

    @Builder
    public OrderSaveDto(User user, List<OrderItem> orderItems, Delivery delivery, OrderStatus orderStatus) {
        this.user = user;
        this.orderItems = orderItems;
        this.delivery = delivery;
        this.orderStatus = orderStatus;
    }

    public Order toEntity() {
        return Order.builder()
                .user(user)
                .orderItems(orderItems)
                .delivery(delivery)
                .orderStatus(orderStatus).build();
    }
}
