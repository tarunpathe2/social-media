package com.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.model.Likes;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long>{

	public Long countByPostId(Long id);
}
