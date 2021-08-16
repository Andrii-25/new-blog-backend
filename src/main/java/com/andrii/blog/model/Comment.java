package com.andrii.blog.model;

import com.andrii.blog.entity.CommentEntity;

public class Comment {

    private Long id;
    private Long postId;
    private String text;
    private String date;
    private String author;

    public static Comment toModel(CommentEntity commentEntity) {
        Comment model = new Comment();
        model.setId(commentEntity.getId());
        model.setPostId(commentEntity.getPostId());
        model.setText(commentEntity.getText());
        model.setDate(commentEntity.getDate());
        model.setAuthor(commentEntity.getAuthor());
        return model;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
