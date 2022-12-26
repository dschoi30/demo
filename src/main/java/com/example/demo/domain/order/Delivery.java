package com.example.demo.domain.order;

import com.example.demo.domain.user.Address;
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
}
