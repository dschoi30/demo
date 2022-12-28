package com.example.demo.domain.posts.dto;

import com.example.demo.domain.posts.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveDto {
    private String userName;
    private String title;
    private String content;

    @Builder
    public PostSaveDto(String userName, String title, String content) {
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .userName(userName)
                .title(title)
                .content(content)
                .build();
    }
}
