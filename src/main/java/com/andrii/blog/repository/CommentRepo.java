package com.andrii.blog.repository;

import com.andrii.blog.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<CommentEntity, Long> {
}
