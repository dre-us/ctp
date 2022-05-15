package com.unal.ctp.model;

import com.unal.ctp.datastructures.*;

public class Pensum {

	private	ArrayList<Course> courses;
	private ArrayList<Integer> semester;

	public Pensum() {
		this.courses = new ArrayList<Course>();
		this.semester = new ArrayList<Integer>();
	}

	public boolean contains(Course course) {
		return courses.find(course) != -1;
	}

	public void insertSemester(ArrayList<Courses> newCourses) {
		for (int i = 0; i < newCourses.size(); ++i)
			courses.insertBack(newCourses.get(i));
		semester.insertBack(newCourses.size());
	}

	public void deleteSemester() {
		if (semester.size() == 0) return;
		for (int i = 0; i < semester.getBack(); ++i)
			courses.deleteBack();
	}
}
