package com.example.demo.domain.users.dto;

import com.example.demo.domain.orders.Order;
import com.example.demo.domain.users.Address;
import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserUpdateDto {

    private String password;

    @Embedded
    private Address address;

    @Builder
    public UserUpdateDto(String name, String password, Address address, List<Order> orders) {
        this.password = password;
        this.address = address;
    }
}
