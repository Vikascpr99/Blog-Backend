package com.blogBackend.Blog.Backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class BlogBackendApplication {

	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(BlogBackendApplication.class, args);
	}

}
