package com.blogBackend.Blog.Backend.controllers;

import com.blogBackend.Blog.Backend.payloads.ApiResponse;
import com.blogBackend.Blog.Backend.payloads.UserDto;
import com.blogBackend.Blog.Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    //Post Create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }


    //Put Update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer u_id) {
        UserDto updatedUser = this.userService.updateUser(userDto, u_id);
    return ResponseEntity.ok(updatedUser);
    }



    //Delete Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer u_id){
        this.userService.deleteUser(u_id);

//        return new ResponseEntity(Map.of("Message", "User Deleted Successfully"), HttpStatus.OK);
        ResponseEntity user_deleted_successfully = new ResponseEntity(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
        return user_deleted_successfully;

    }



    //Get Get user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


    //Get Single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer u_id)
    {
        return ResponseEntity.ok(this.userService.getUserById(u_id));
    }


}
