package com.andrii.blog.controller;

import com.andrii.blog.entity.PostEntity;
import com.andrii.blog.exception.PostNotFoundException;
import com.andrii.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity addPost(@RequestBody PostEntity postEntity){
        try {
            return ResponseEntity.ok(postService.addPost(postEntity));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping
    public ResponseEntity getOne(@RequestParam Long id){
        try {
            return ResponseEntity.ok(postService.getOne(id));
        }
        catch(PostNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(postService.getAll());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        postService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody PostEntity postEntity, Long id){
        try {
            return ResponseEntity.ok(postService.updatePost(postEntity, id));
        }
        catch(PostNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
