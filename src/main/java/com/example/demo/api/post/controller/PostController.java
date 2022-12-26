package com.example.demo.api.post.controller;

import com.example.demo.domain.post.repository.PostForm;
import com.example.demo.domain.post.repository.PostUpdateDto;
import com.example.demo.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostForm postForm) {
        return postService.save(postForm);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        return postService.update(id, postUpdateDto);
    }


}
