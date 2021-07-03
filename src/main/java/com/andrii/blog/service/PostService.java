package com.andrii.blog.service;

import com.andrii.blog.entity.PostEntity;
import com.andrii.blog.exception.PostNotFoundException;
import com.andrii.blog.model.Post;
import com.andrii.blog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public PostEntity addPost(PostEntity postEntity){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        postEntity.setDate(formatter.format(new Date()));
        return postRepo.save(postEntity);
    }

    public Post getOne(Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("Post not found!");
        }
        return Post.toModel(post);
    }

    public List<Post> getAll(){
        List<Post> posts = new ArrayList<>();
        postRepo.findAll().forEach(p -> {
            Post model = Post.toModel(p);
            posts.add(model);
        });
        return posts;
    }

    public void delete(Long id){
        postRepo.deleteById(id);
    }

    public Post updatePost(PostEntity postEntity, Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("Post not found!");
        }
        post.setTitle(postEntity.getTitle());
        post.setText(postEntity.getText());
        post.setAuthor(postEntity.getAuthor());
        post.setCategory(postEntity.getCategory());
        return Post.toModel(post);
    }
}
