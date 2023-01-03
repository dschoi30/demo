package com.example.demo.domain.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ItemImage {

    @Id @GeneratedValue
    @Column(name = "item_image_id")
    private Long id;

    private String renamedFileName;

    private String originalFileName;

    private String imageUrl;

    private String repImgYn;

    @JsonIgnore
    @JoinColumn(name = "item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;
}
