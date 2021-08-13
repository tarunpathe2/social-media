package com.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.model.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long>{

}
