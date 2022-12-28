package com.example.demo.domain.users.dto;

import com.example.demo.domain.orders.Order;
import com.example.demo.domain.users.Address;
import com.example.demo.domain.users.User;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserSaveDto {

    private String name;
    private String password;

    private int zipCode;
    private String address;
    private String subAddress;

    @Builder
    public UserSaveDto(String name, String password, int zipCode, String address, String subAddress) {
        this.name = name;
        this.password = password;
        this.zipCode = zipCode;
        this.address = address;
        this.subAddress = subAddress;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .address(new Address(zipCode, address, subAddress))
                .build();
    }
}
