package com.example.demo.domain.items.dto;

import com.example.demo.domain.items.Item;
import com.example.demo.domain.items.ItemImage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemSaveDto {

    private String itemName;
    private int price;
    private int stockQuantity;
    private String content;

    @Enumerated(EnumType.STRING)
    private boolean onSale;

    @OneToMany(mappedBy = "item")
    private List<ItemImage> itemImages;

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .price(price)
                .stockQuantity(stockQuantity)
                .content(content)
                .onSale(onSale)
                .build();
    }
}
