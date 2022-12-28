package com.example.demo.domain.orders.repository;

import com.example.demo.domain.orders.Order;
import com.example.demo.domain.orders.OrderStatus;
import com.example.demo.domain.users.Address;
import com.example.demo.domain.users.User;
import com.example.demo.domain.users.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class OrderRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired OrderRepository orderRepository;

    @Test
    public void order_test() throws Exception {

        //given
        User user = userRepository.save(User.builder()
                .name("admin")
                .address(new Address(12312, "서울시", "강남구")).build());


        orderRepository.save(Order.builder()
                .user(user)
                .delivery(delivery)
                .orderItems(orderItems)
                .orderStatus(OrderStatus.ORDERED).build());
        //when

        //then

    }
}