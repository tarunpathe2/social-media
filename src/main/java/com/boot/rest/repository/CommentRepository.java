package com.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.model.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

}