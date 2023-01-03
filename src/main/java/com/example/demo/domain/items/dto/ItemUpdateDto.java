package com.example.demo.domain.items.dto;

import com.example.demo.domain.items.ItemImage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemUpdateDto {

    private String itemName;
    private int price;
    private int stockQuantity;
    private String content;
    private boolean onSale;

    @OneToMany(mappedBy = "item")
    private List<ItemImage> itemImages;
}
