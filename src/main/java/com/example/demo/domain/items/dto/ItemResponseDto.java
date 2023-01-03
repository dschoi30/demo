package com.example.demo.domain.items.dto;

import com.example.demo.domain.items.Item;
import com.example.demo.domain.items.ItemImage;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemResponseDto {

    private Long id;
    private String itemName;
    private int price;
    private int stockQuantity;
    private String content;
    private boolean onSale;

    @OneToMany(mappedBy = "item")
    private List<ItemImage> itemImages;

    public ItemResponseDto(Item entity) {
        this.id = entity.getId();
        this.itemName = entity.getItemName();
        this.price = entity.getPrice();
        this.stockQuantity = entity.getStockQuantity();
        this.content = entity.getContent();
        this.onSale = entity.isOnSale();
        this.itemImages = entity.getItemImages();
    }
}
