package com.andrii.blog.service;

import com.andrii.blog.entity.CommentEntity;
import com.andrii.blog.exception.CommentNotFoundException;
import com.andrii.blog.model.Comment;
import com.andrii.blog.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public CommentEntity addComment(CommentEntity commentEntity){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        commentEntity.setDate(formatter.format(new Date()));
        return commentRepo.save(commentEntity);
    }

    public List<Comment> getAllComments(){
        List<Comment> comments = new ArrayList<>();
        commentRepo.findAll().forEach(c -> {
            Comment model = Comment.toModel(c);
            comments.add(model);
        });
        return comments;
    }

    public void deleteComment(Long id){
        commentRepo.deleteById(id);
    }

    public Comment updateComment(CommentEntity commentEntity, Long id) throws CommentNotFoundException {
        CommentEntity comment = commentRepo.findById(id).get();
        if(comment == null){
            throw new CommentNotFoundException("Comment not found!");
        }
        comment.setPostId(commentEntity.getPostId());
        comment.setText(commentEntity.getText());
        comment.setDate(commentEntity.getDate());
        comment.setAuthor(commentEntity.getAuthor());
        return Comment.toModel(comment);
    }
}
