package com.blogBackend.Blog.Backend.services;

import com.blogBackend.Blog.Backend.entities.Post;
import com.blogBackend.Blog.Backend.payloads.PostDto;

import java.util.List;

public interface PostService {

// Create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);


//    Update
    PostDto updatePost(PostDto postDto , Integer postId);


//    Delete
    void deletePost (Integer postId);

//    Get All Posts
    List<PostDto> getAllPost();

//    Get Single Posts
    PostDto getPostById (Integer postId);

//    Get all post by Category

    List<PostDto> getPostByCategory (Integer categoryId);
// Get all Post by User
    List<PostDto> getPostByUser (Integer userId);

//   Search Posts
    List <Post> searchPosts(String keyword);

}
