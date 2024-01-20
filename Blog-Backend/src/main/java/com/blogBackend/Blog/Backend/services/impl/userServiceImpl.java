package com.blogBackend.Blog.Backend.services.impl;

import com.blogBackend.Blog.Backend.entities.User;
import com.blogBackend.Blog.Backend.payloads.UserDto;
import com.blogBackend.Blog.Backend.reposetories.UserRepo;
import com.blogBackend.Blog.Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class userServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(user.getId());
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(user.getAbout());

        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(userDto.getId());
        userDto.setPassword(userDto.getPassword());
        userDto.setName(userDto.getName());
        userDto.setEmail(userDto.getEmail());
        userDto.setAbout(userDto.getAbout());

        return userDto;
    }



}
