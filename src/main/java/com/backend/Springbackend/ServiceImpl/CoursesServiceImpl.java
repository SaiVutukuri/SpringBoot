package com.backend.Springbackend.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.backend.Springbackend.Entity.Courses;
import com.backend.Springbackend.Entity.User;
import com.backend.Springbackend.Repository.CoursesRepository;
import com.backend.Springbackend.Service.CoursesService;
@Service
public class CoursesServiceImpl implements CoursesService{
	@Autowired
	private CoursesRepository coursesRepository;

	@Override
	public List<Courses> getAllCourses() {
		return coursesRepository.findAll();
	}

	@Override
	public Courses addCourses(Courses courses) {
		return coursesRepository.save(courses);
	}

	@Override
	public Courses getCoursesById(int cId) {
		if (coursesRepository.findById(cId).isPresent()) {
			return coursesRepository.findById(cId).get();
	    }else {
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Courses with id %d not found", cId));
	    }
	}

	public void deleteCoursesById(int cId) {
		try {
			coursesRepository.deleteById(cId);
		} catch (DataAccessException ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<Courses> getStatus(String status) {
		List<Courses> statuses = new ArrayList<Courses>();
		statuses=coursesRepository.findByStatus(status);
		return statuses;
	}

	@Override
	public void updateStatus(Courses courses) {
		Courses coursesDB = coursesRepository.findById(courses.getcId()).orElseThrow();
		coursesRepository.save(courses);
	}
}
