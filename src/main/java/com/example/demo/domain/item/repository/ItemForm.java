package com.example.demo.domain.item.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemForm {

    private String itemName;
    private int price;
    private int stockQuantity;
}
