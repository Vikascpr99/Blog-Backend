package com.blogBackend.Blog.Backend.controllers;

import com.blogBackend.Blog.Backend.entities.Comment;
import com.blogBackend.Blog.Backend.payloads.ApiResponse;
import com.blogBackend.Blog.Backend.payloads.CommentDto;
import com.blogBackend.Blog.Backend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment (@RequestBody CommentDto comment,
                                                     @PathVariable Integer postId){

        CommentDto createdComment = this.commentService.createComment(comment, postId);

        return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);

    }
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment (@PathVariable Integer commentId){

        this.commentService.deleteComment(commentId);

        return new ResponseEntity<ApiResponse>(new ApiResponse( "Comment deleted Successfully !!",true),HttpStatus.OK);

    }

}
