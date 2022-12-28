package com.example.demo.domain.orders.service;

import com.example.demo.domain.items.repository.ItemRepository;
import com.example.demo.domain.orders.Delivery;
import com.example.demo.domain.orders.Order;
import com.example.demo.domain.orders.OrderItem;
import com.example.demo.domain.orders.OrderStatus;
import com.example.demo.domain.orders.repository.OrderRepository;
import com.example.demo.domain.users.User;
import com.example.demo.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final UserRepository userRepository;
//    private final OrderRepository orderRepository;
//    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long id, List<OrderItem> orderItems, int count) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 주문 내역이 없습니다."));

        Delivery delivery = new Delivery(user.getAddress());

        Order order = Order.builder()
               .user(user)
               .orderItems(orderItems)
               .delivery(delivery)
               .orderStatus(OrderStatus.ORDERED)
        .build();

        return order.getId();
    }

}
