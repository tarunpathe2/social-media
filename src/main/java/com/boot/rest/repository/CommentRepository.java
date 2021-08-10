package com.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.rest.model.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long> {

}
