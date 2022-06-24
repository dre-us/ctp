package com.unal.edu.co.ctp.service;

import java.util.List;
import com.unal.edu.co.ctp.model.Course;
import com.unal.edu.co.ctp.model.CourseDTO;

public interface ICourseService {

	abstract public List<Course> findAll();
	abstract public CourseDTO find(Integer id);

}
