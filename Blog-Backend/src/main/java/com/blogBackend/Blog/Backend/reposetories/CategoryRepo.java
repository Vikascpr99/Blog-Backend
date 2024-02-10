package com.blogBackend.Blog.Backend.reposetories;

import com.blogBackend.Blog.Backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Integer> {
}
