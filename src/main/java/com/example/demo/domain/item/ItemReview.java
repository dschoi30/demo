package com.example.demo.domain.item;

import com.example.demo.domain.common.BaseTimeEntity;
import com.example.demo.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ItemReview extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "item_review_id")
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    private String title;

    private String content;
}