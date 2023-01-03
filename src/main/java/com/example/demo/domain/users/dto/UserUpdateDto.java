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
    private String email;
    private int zipCode;
    private String address;
    private String subAddress;

    @Builder
    public UserUpdateDto(String password, String email, int zipCode, String address, String subAddress) {
        this.password = password;
        this.email = email;
        this.zipCode = zipCode;
        this.address = address;
        this.subAddress = subAddress;
    }
}
