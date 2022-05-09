package com.backend.Springbackend.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Springbackend.Entity.Courses;
import com.backend.Springbackend.Service.CoursesService;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CoursesController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	CoursesService coursesService;
	  // Insert courses record
	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public Courses addCourses(@RequestBody Courses courses) {
	    return coursesService.addCourses(courses);
	  }
	  // Fetch all courses records
	  @GetMapping
	  public List<Courses> getAllCourses(){
	    return coursesService.getAllCourses();
	  }
	  // Fetch single user
	  @GetMapping("/{id}")
	  public Courses getCoursesById(@PathVariable("id") int cId){
	    try {
	    	 coursesService.getCoursesById(cId);
	    	 logger.info("Get Course By ID Success");
	    	return coursesService.getCoursesById(cId);
		} catch (Exception e) {
			logger.error ("Course Not Found "+e.getMessage(),HttpStatus.NOT_FOUND);
			return null;
		}
	  
	  }
	  // Delete Course record
	  @DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteCourse(@PathVariable int id){
	    try {
	      coursesService.deleteCoursesById(id);
	      logger.info("Delete Course By ID Success");
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(Exception ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      logger.error ("Course Not Found "+ex.getMessage(),HttpStatus.NOT_FOUND);
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	  }
	  // get by status
	  @GetMapping("status/{status}")
	  public List<Courses> getStatus(@PathVariable("status") String status){
	    return coursesService.getStatus(status);
	  }
	  // Update user record
	  @PutMapping("/updatestatus")
	  public ResponseEntity<String> updateStatus(@RequestBody Courses courses) {  
	    try {
	      coursesService.updateStatus(courses);
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(NoSuchElementException ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	  }
}
