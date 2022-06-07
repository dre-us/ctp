package com.unal.edu.co.ctp.model;

import java.util.ArrayList;

public class Condition {

	private static Integer conditions = 0;

	private Integer id;
	private Integer degree;
	private Integer course;
	private ArrayList<Course> courses;

	public Condition(Integer degree, Integer course) {
		this.setId();
		this.setDegree(degree);
		this.setCourse(course);
		this.courses = new ArrayList<Course>();
	}

	public Condition() {
		this.courses = new ArrayList<Course>();
	}

	public void setId() {
		this.id = ++conditions;
	}

	public Integer getId() {
		return this.id;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public Integer getCourse() {
		return this.course;
	}

	public boolean insertCourse(Course course) {
		return this.courses.add(course);
	}

	public boolean deleteCourse(Course course) {
		return this.courses.remove(course);
	}

	public ArrayList<Course> getCourses() {
		return this.courses;
	}

	public void update(ArrayList<Course> dataCourses) {
		for (int i = 0; i < this.courses.size(); ++i) {
			int j = dataCourses.indexOf(this.courses.get(i));
			if (j != -1) this.courses.set(i, dataCourses.get(j));
		}
	}

	public ConditionDTO getDTO() {
		ConditionDTO condition = new ConditionDTO();
		ArrayList<String> nameCourses = new ArrayList<String>();
		for (int i = 0; i < courses.size(); ++i)
			nameCourses.add(courses.get(i).getName());
		condition.setCourses(nameCourses);
		return condition;
	}

	@Override
	public String toString() {
		String dataCondition = "";
		for (int i = 0; i < this.courses.size(); ++i) {
			dataCondition += this.courses.get(i).getName();
			if (i != this.courses.size() - 1)
				dataCondition += ", ";
		}
		return dataCondition;
	}

}
