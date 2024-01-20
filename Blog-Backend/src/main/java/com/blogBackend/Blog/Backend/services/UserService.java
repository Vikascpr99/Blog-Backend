package com.blogBackend.Blog.Backend.services;

import com.blogBackend.Blog.Backend.entities.User;
import com.blogBackend.Blog.Backend.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);

}
