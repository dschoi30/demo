package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.Post;
import com.example.demo.domain.post.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PostConstruct
    public void init() {
        Post savedPost = postRepository.save(Post.builder()
                .userName("admin")
                .title("title")
                .content("content")
                .build());
    }

    @Test
    public void save_post() {
        //given

        //when
        List<Post> all = postRepository.findAll();

        //then
        assertThat(all.get(0).getUserName()).isEqualTo("admin");
    }

    @Test
    public void update_post() {
        //given

        //when
        List<Post> post = postRepository.findByUserName("admin");
        post.get(0).update("title2", "content2");

        //then
        assertThat(post.get(0)).hasFieldOrPropertyWithValue("title", "title2");
    }

    @Test
    public void delete_post() {
        //given
        List<Post> all = postRepository.findAll();
        //when
        postRepository.delete(all.get(0));
        long count = postRepository.count();
        //then
        assertThat(count).isEqualTo(0);
    }
}