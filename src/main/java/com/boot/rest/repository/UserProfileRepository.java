package com.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
