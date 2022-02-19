package com.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
}
