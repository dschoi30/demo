package com.example.demo.domain.posts.service;

import com.example.demo.domain.posts.Post;
import com.example.demo.domain.posts.dto.PostResponseDto;
import com.example.demo.domain.posts.repository.PostRepository;
import com.example.demo.domain.posts.dto.PostSaveDto;
import com.example.demo.domain.posts.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveDto postSaveDto) {
        return postRepository.save(postSaveDto.toEntity()).getId();
    }

    public Long update(Long id, PostUpdateDto postUpdateDto) {

        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.update(postUpdateDto.getTitle(), postUpdateDto.getContent());

        return post.getId();
    }

    public PostResponseDto findById(Long id) {

        Post entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        return new PostResponseDto(entity);
    }
}
