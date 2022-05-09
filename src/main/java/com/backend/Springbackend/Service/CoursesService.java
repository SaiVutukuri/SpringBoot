package com.backend.Springbackend.Service;

import java.util.List;
import com.backend.Springbackend.Entity.Courses;

public interface CoursesService {
	List<Courses> getAllCourses();
	Courses getCoursesById(int cId);
	Courses addCourses(Courses courses);
	void deleteCoursesById(int cId);
	List<Courses> getStatus(String status);
	void updateStatus(Courses courses);
}