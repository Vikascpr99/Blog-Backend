package com.blogBackend.Blog.Backend.reposetories;

import com.blogBackend.Blog.Backend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
