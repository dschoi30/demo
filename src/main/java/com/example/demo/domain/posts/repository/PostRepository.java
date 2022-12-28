package com.example.demo.domain.posts.repository;

import com.example.demo.domain.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(@Param("title") String title);
}