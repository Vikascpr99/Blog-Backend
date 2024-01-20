package com.blogBackend.Blog.Backend.services.impl;

import com.blogBackend.Blog.Backend.entities.User;
import com.blogBackend.Blog.Backend.exceptions.customException.ResourceNotFoundException;
import com.blogBackend.Blog.Backend.payloads.UserDto;
import com.blogBackend.Blog.Backend.reposetories.UserRepo;
import com.blogBackend.Blog.Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updateUser);


        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User","id",userId));


        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().
                map(user -> this.userToDto(user)).collect(Collectors.toList());


        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);

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
