package com.example.demo.domain.user;

import com.example.demo.domain.common.BaseTimeEntity;
import com.example.demo.domain.order.Order;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> Orders = new ArrayList<>();
}
