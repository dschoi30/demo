package com.example.demo.domain.items;

import com.example.demo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private boolean onSale;

    @OneToMany(mappedBy = "item")
    private List<ItemImage> itemImages;

    @OneToMany(mappedBy = "item")
    private List<ItemReview> itemReviews;

    @Builder
    public Item(String itemName, int price, int stockQuantity, String content, boolean onSale, List<ItemImage> itemImages, List<ItemReview> itemReviews) {
        this.itemName = itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.content = content;
        this.onSale = onSale;
        this.itemImages = itemImages;
        this.itemReviews = itemReviews;
    }

    public Item update(String itemName, int price, int stockQuantity, String content, boolean onSale, List<ItemImage> itemImages) {
        this.itemName = itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.content = content;
        this.onSale = onSale;
        this.itemImages = itemImages;
        return this;
    }
}
