package com.example.demo.domain.users;

import com.example.demo.domain.carts.Cart;
import com.example.demo.domain.common.BaseTimeEntity;
import com.example.demo.domain.orders.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String password;
    private String email;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User(String name, String password, String email, Address address, Role role, Cart cart, List<Order> orders) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role;
        this.cart = cart;
        this.orders = orders;
    }

    public User update(String password, String email, Address address) {
        this.password = password;
        this.email = email;
        this.address = address;
        return this;
    }
}
