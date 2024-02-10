package com.blogBackend.Blog.Backend.services;

import com.blogBackend.Blog.Backend.payloads.CategoryDto;

import java.util.List;


public interface CategoryService {

    // Create
     CategoryDto createCategory(CategoryDto categoryDto);
    //Update
     CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //Delete
     void deleteCategory(Integer categoryId);
    // Get
     CategoryDto getCategory(Integer categoryId);
    //Get All Category
     List<CategoryDto> getCategories();

}
