package com.securitydemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitydemo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String username);

	
}
