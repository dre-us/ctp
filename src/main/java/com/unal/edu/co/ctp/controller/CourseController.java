package com.unal.edu.co.ctp.controller;

import java.util.List;
import java.util.ArrayList;
import com.unal.edu.co.ctp.model.Course;
import com.unal.edu.co.ctp.model.CourseDTO;
import com.unal.edu.co.ctp.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

	@Autowired
	private ICourseService courseService;

	@GetMapping(value = "/courses")
	public List<CourseDTO> getCourses() {
		List<Course> courses = courseService.findAll();
		ArrayList<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		for (int i = 0; i < courses.size(); ++i)
			coursesDTO.add(courses.get(i).getDTO());
		return coursesDTO;
	}

	@GetMapping(value = "/course/{id}")
	public CourseDTO getCourse(@PathVariable Integer id) {
		return courseService.find(id);
	}
}
