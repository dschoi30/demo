package com.example.demo.domain.users.dto;

import com.example.demo.domain.orders.Order;
import com.example.demo.domain.users.Address;
import com.example.demo.domain.users.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String password;
    private Address address;
    private List<Order> orders;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.address = entity.getAddress();
        this.orders = entity.getOrders();
    }
}
