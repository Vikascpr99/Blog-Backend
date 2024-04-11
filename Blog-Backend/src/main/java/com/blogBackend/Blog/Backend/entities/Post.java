package com.blogBackend.Blog.Backend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Table(name = "post")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;
    @Column(name = "post_title",nullable = false)
    @NotBlank
    @Size(min = 4,max = 30,message = "title should be only 4 to 30 character")
    private String title;
    @Column(name = "post_content",nullable = false)
    @NotBlank
    @Size(min = 20,max = 100,message = "Content should be Min of 4 and Max of 100 character")
    private String content;
    private String imageName;

    private Date addedDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set <Comment> comments = new HashSet<>();




}
