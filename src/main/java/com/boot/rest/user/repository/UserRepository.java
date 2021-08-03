package com.boot.rest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
