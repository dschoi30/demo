package com.example.demo.domain.orders;

import com.example.demo.domain.carts.Cart;
import com.example.demo.domain.items.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int amount;

    public void setOrder(Order order) {
        this.order = order;
    }

    @Builder
    public OrderItem(Item item, Order order, int orderPrice, int amount) {
        this.item = item;
        this.order = order;
        this.orderPrice = orderPrice;
        this.amount = amount;
    }
}
