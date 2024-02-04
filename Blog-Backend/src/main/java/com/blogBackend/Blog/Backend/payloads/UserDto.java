package com.blogBackend.Blog.Backend.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {


    private int id;


    @NotEmpty
    @Size(min = 4,max = 20, message = "Please provide minimum 4 characters and max 15 characters in Name")
    private String name;
    @NotBlank(message = "Email must not have empty value")
    @Email(message = "Please provide valid email")
    private String email;
    @NotEmpty
    @Size(min = 8,max = 15, message = "Please provide minimum 8 characters and max 15 characters")
    private String password;
    @NotEmpty
    private String about;
}
