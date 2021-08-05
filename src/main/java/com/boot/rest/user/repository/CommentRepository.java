package com.boot.rest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.rest.user.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long> {

}
