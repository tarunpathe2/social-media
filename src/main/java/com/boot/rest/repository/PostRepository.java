package com.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
