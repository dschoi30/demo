package com.example.demo.domain.carts;

import com.example.demo.domain.orders.OrderItem;
import com.example.demo.domain.users.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<OrderItem> orderItems = new ArrayList<>();

    private int totalPrice;

    @Builder
    public Cart(User user, List<OrderItem> orderItems, int totalPrice) {
        this.user = user;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }
}
