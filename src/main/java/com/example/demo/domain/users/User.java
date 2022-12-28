package com.example.demo.domain.users;

import com.example.demo.domain.common.BaseTimeEntity;
import com.example.demo.domain.orders.Order;
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

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User(String name, String password, Address address, List<Order> orders) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.orders = orders;
    }

    public User update(String password, Address address) {
        this.password = password;
        this.address = address;

        return this;
    }
}
