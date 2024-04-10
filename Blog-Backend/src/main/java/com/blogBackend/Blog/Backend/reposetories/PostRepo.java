package com.blogBackend.Blog.Backend.reposetories;

import com.blogBackend.Blog.Backend.entities.Category;
import com.blogBackend.Blog.Backend.entities.Post;
import com.blogBackend.Blog.Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer>{

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);


}
