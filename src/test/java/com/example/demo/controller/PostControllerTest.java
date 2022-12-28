package com.example.demo.controller;

import com.example.demo.domain.posts.Post;
import com.example.demo.domain.posts.repository.PostRepository;
import com.example.demo.domain.posts.dto.PostSaveDto;
import com.example.demo.domain.posts.dto.PostUpdateDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @LocalServerPort private int port;

    @Autowired private TestRestTemplate testRestTemplate;

    @Autowired private PostRepository postRepository;

    @Test
    public void save_post() {
        //given
        String title = "title";
        String content = "content";
        PostSaveDto postForm = PostSaveDto.builder()
                .title(title)
                .content(content)
                .build();

        String url = "http://localhost:" + port + "/api/v1/post";

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, postForm, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
    }

    @Test
    @Disabled
    public void update_post() {
        Post savedPost = postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .build());

        Long savedPostId = savedPost.getId();
        String updatedTitle = "title2";
        String updatedContent = "content2";

        PostUpdateDto postUpdateDto = PostUpdateDto.builder()
                .title(updatedTitle)
                .content(updatedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/post/" + savedPostId;

        HttpEntity<PostUpdateDto> requestEntity = new HttpEntity<>(postUpdateDto);

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(updatedTitle);
    }
}