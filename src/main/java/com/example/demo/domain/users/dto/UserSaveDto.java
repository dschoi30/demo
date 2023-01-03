package com.example.demo.domain.users.dto;

import com.example.demo.domain.orders.Order;
import com.example.demo.domain.users.Address;
import com.example.demo.domain.users.Role;
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
    private String email;
    private int zipCode;
    private String address;
    private String subAddress;
    private Role role;

    @Builder
    public UserSaveDto(String name, String password, String email, int zipCode, String address, String subAddress, Role role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.zipCode = zipCode;
        this.address = address;
        this.subAddress = subAddress;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .email(email)
                .address(new Address(zipCode, address, subAddress))
                .role(role)
                .build();
    }
}
