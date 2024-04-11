package com.blogBackend.Blog.Backend.services;

import com.blogBackend.Blog.Backend.entities.Post;
import com.blogBackend.Blog.Backend.payloads.PostDto;
import com.blogBackend.Blog.Backend.payloads.PostResponse;

import java.util.List;

public interface PostService {

// Create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);


//    Update
    PostDto updatePost(PostDto postDto , Integer postId);


//    Delete
    void deletePost (Integer postId);

//    Get All Posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

//    Get Single Posts
    PostDto getPostById (Integer postId);

//    Get all post by Category

    List<PostDto> getPostByCategory (Integer categoryId);
// Get all Post by User
    List<PostDto> getPostByUser (Integer userId);

//   Search Posts
    List <PostDto> searchPosts(String keyword);

}
