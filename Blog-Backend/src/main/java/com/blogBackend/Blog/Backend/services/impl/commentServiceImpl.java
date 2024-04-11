package com.blogBackend.Blog.Backend.services.impl;

import com.blogBackend.Blog.Backend.entities.Comment;
import com.blogBackend.Blog.Backend.entities.Post;
import com.blogBackend.Blog.Backend.exceptions.customException.ResourceNotFoundException;
import com.blogBackend.Blog.Backend.payloads.CommentDto;
import com.blogBackend.Blog.Backend.reposetories.CommentRepo;
import com.blogBackend.Blog.Backend.reposetories.PostRepo;
import com.blogBackend.Blog.Backend.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

        Comment comment = this.mapper.map(commentDto, Comment.class);
        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.mapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment com = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment ", "comment id", commentId));
        this.commentRepo.delete(com);
    }
}
