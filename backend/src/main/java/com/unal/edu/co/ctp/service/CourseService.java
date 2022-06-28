package com.unal.edu.co.ctp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.unal.edu.co.ctp.model.Course;
import com.unal.edu.co.ctp.model.CourseDTO;
import com.unal.edu.co.ctp.model.Condition;
import com.unal.edu.co.ctp.datastructures.AVL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CourseService implements ICourseService {

	private ArrayList<Course> courses;
	private AVL<Course> coursesTree;

	public CourseService() {
		courses = input();
		this.coursesTree = new AVL<Course>();
		for (int i = 0; i < courses.size(); ++i)
			coursesTree.insertAVL(courses.get(i));
	}

	@Override
	public List<Course> findAll() {
		return courses;
	}

	@Override
	public CourseDTO find(Integer id) {
		Course course = coursesTree.find(new Course(id));
		if (course != null) return course.getDTO();
		return null;
	}

	private ArrayList<Course> input() {
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/data7.in"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] dataCourse = line.split("[;] ");
				String[] requirements = dataCourse[dataCourse.length - 1].split("[\\[\\]]|[,] ");
				Integer id = Integer.parseInt(dataCourse[0]);
				String name = dataCourse[1];
				Integer credits = Integer.parseInt(dataCourse[2]);
				Boolean mandatory = dataCourse[3].equals("SI") ? true : false;
				String component = dataCourse[4];
				Course course = new Course(id, name, credits, mandatory, component);
				for (int i = 1; i < requirements.length; ++i) {
					Condition condition = new Condition(2879, id);
					Integer idRequirement = Integer.parseInt(requirements[i]);
					Course requirement = new Course(idRequirement);
					condition.insertCourse(requirement);
					course.insertCondition(condition);
				}
				courses.add(course);
			}
			for (int i = 0; i < courses.size(); ++i) {
				courses.get(i).update(courses);
			}
			br.close();
		} catch (IOException e) {
			return courses;
		}
		return courses;
	}
}
