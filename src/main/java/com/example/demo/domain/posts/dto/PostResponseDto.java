package com.example.demo.domain.posts.dto;

import com.example.demo.domain.posts.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String userName;
    private String title;
    private String content;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
