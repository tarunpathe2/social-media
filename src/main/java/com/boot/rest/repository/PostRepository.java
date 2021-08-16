package com.boot.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.model.Post;
import com.boot.rest.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//	public List<Post> findByUser(User user);
}
