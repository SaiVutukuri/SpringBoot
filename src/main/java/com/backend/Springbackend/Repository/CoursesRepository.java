package com.backend.Springbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Springbackend.Entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	List<Courses> findByStatus(String status);
}