package com.example.demo.api.posts.controller;

import com.example.demo.domain.posts.dto.PostSaveDto;
import com.example.demo.domain.posts.dto.PostUpdateDto;
import com.example.demo.domain.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveDto postForm) {
        return postService.save(postForm);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        return postService.update(id, postUpdateDto);
    }
}
