package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostForm {
    private String userName;
    private String title;
    private String content;

    @Builder
    public PostForm(String userName, String title, String content) {
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public PostForm(Post entity) {
        this.userName = entity.getUserName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

    public Post toEntity() {
        return Post.builder()
                .userName(userName)
                .title(title)
                .content(content)
                .build();
    }
}
