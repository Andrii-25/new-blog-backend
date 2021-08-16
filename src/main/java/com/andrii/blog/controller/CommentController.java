package com.andrii.blog.controller;

import com.andrii.blog.entity.CommentEntity;
import com.andrii.blog.exception.CommentNotFoundException;
import com.andrii.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentEntity commentEntity){
        try {
            return ResponseEntity.ok(commentService.addComment(commentEntity));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(commentService.getAllComments());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CommentEntity commentEntity, Long id){
        try {
            return ResponseEntity.ok(commentService.updateComment(commentEntity, id));
        }
        catch(CommentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
