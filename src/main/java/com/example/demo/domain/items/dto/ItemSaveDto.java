package com.example.demo.domain.items.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemSaveDto {

    private String itemName;
    private int price;
    private int stockQuantity;
    private String content;
}
