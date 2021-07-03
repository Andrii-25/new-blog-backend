package com.andrii.blog.exception;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String message) {
        super(message);
    }
}
