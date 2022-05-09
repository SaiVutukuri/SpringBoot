package com.backend.Springbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Springbackend.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByRole(String role);
	User findByEmailAndPassword(String email, String password);
}