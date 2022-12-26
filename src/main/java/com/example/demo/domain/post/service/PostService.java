package com.example.demo.domain.post.service;

import com.example.demo.domain.post.Post;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.repository.PostForm;
import com.example.demo.domain.post.repository.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostForm postForm) {
        return postRepository.save(postForm.toEntity()).getId();
    }

    public Long update(Long id, PostUpdateDto postUpdateDto) {

        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.update(postUpdateDto.getTitle(), postUpdateDto.getContent());

        return post.getId();
    }

    public PostForm findById(Long id) {

        Post entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        return new PostForm(entity);
    }
}
