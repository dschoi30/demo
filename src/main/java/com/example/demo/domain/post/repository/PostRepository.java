package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.userName in :userName")
    List<Post> findByUserName(@Param("userName") String userName);

}