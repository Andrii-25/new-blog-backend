package com.andrii.blog.repository;

import com.andrii.blog.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<PostEntity, Long> {
}
