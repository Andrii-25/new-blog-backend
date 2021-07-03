package com.andrii.blog.model;

import com.andrii.blog.entity.PostEntity;

import java.util.Date;

public class Post {

    private Long id;
    private String title;
    private String text;
    private String author;
    private String category;
    private String date;

    public static Post toModel(PostEntity postEntity) {
        Post model = new Post();
        model.setId(postEntity.getId());
        model.setTitle(postEntity.getTitle());
        model.setText(postEntity.getText());
        model.setAuthor(postEntity.getAuthor());
        model.setCategory(postEntity.getCategory());
        model.setDate(postEntity.getDate());
        return model;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
