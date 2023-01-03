package com.example.demo.domain.items.dto;

import lombok.Getter;

@Getter
public class ItemImageSaveDto {

    private Long id;

    private String renamedFileName;

    private String originalFileName;

    private String imageUrl;

    private String repImgYn;
}
