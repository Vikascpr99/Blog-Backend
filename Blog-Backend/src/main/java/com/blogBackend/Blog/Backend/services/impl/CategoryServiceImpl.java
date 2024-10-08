package com.blogBackend.Blog.Backend.services.impl;

import com.blogBackend.Blog.Backend.entities.Category;
import com.blogBackend.Blog.Backend.exceptions.customException.ResourceNotFoundException;
import com.blogBackend.Blog.Backend.payloads.CategoryDto;
import com.blogBackend.Blog.Backend.reposetories.CategoryRepo;
import com.blogBackend.Blog.Backend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper mapper;



    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.mapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
       return this.mapper.map(addedCat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).
                orElseThrow(()-> new ResourceNotFoundException("Category ","Category Id",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updateCat = this.categoryRepo.save(cat);
        return this.mapper.map(updateCat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id ", categoryId));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
        return this.mapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDtos = categories.stream().map((cat) -> this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
