package com.unal.ctp.model;
import com.unal.ctp.data_structures.*;

public class Condition {

	private static Integer conditions = 0;

	private Integer id;
	private String degree;
	private String course;
	private ArrayList<Course> courses;

	public Condition(String degree, String course) {
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

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return this.course;
	}

	public boolean insertCourse(Course course) {
		return this.courses.insert(course);
	}

	public boolean deleteCourse(Course course) {
		return this.courses.remove(course);
	}

	public ArrayList<Course> getCourses() {
		return this.courses;
	}

	public void update(ArrayList<Course> dataCourses) {
		for (int i = 0; i < this.courses.size(); ++i) {
			int j = dataCourses.find(this.courses.get(i));
			if (j != -1) this.courses.set(i, dataCourses.get(j));
		}
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
