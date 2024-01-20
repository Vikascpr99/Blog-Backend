package com.blogBackend.Blog.Backend.reposetories;

import com.blogBackend.Blog.Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
