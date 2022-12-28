package com.example.demo.domain.orders;

import com.example.demo.domain.users.Address;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Delivery(Address address) {
        this.address = address;
    }
}
