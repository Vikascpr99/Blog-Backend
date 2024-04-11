package com.blogBackend.Blog.Backend.services;

import com.blogBackend.Blog.Backend.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment (CommentDto commentDto, Integer postId);
    void deleteComment (Integer commentId);
}
