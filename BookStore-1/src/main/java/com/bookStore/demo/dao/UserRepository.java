package com.bookStore.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByUsername(String username);

}