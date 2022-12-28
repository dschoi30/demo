package com.example.demo.domain.items;

import com.example.demo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Item extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String itemName;
    private int price;
    private int stockQuantity;
    private String content;

    @OneToMany(mappedBy = "item")
    private List<ItemImage> itemImages;

    @OneToMany(mappedBy = "item")
    private List<ItemReview> itemReviews;


}
