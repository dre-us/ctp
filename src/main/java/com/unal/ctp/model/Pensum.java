package com.unal.ctp.model;

import com.unal.ctp.datastructures.*;

public class Pensum {

	public static Integer cont = 0;
	private	ArrayList<Course> courses;
	private ArrayList<Integer> credits;

	public Pensum() {
		this.courses = new ArrayList<Course>();
		this.credits = new ArrayList<Integer>();
	}

	public void setCourses(ArrayList<Course> newCourses) {
		this.courses = newCourses;
	}

	public void setCredits(ArrayList<Integer> newCredits) {
		this.credits = newCredits;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public ArrayList<Integer> getCredits() {
		return credits;
	}

	public boolean contains(Course course) {
		return courses.find(course) != -1;
	}

	public void insertSemester(ArrayList<Course> newCourses) {
		for (int i = 0; i < newCourses.size(); ++i)
			courses.insertBack(newCourses.get(i));
		credits.insertBack(newCourses.size());
	}

	public void removeBack() {
		if (credits.size() == 0) return;
		for (int i = 0; i < credits.getBack(); ++i)
			courses.deleteBack();
	}

	public Pensum copy() {
		Pensum newPensum = new Pensum();
		ArrayList<Course> currCourses = this.getCourses();
		ArrayList<Integer> currCredits = this.getCredits();
		ArrayList<Course> newCourses = new ArrayList<Course>();
		ArrayList<Integer> newCredits = new ArrayList<Integer>();
		for (int i = 0; i < currCourses.size(); ++i)
			newCourses.insertBack(currCourses.get(i));
		for (int i = 0; i < currCredits.size(); ++i)
			newCredits.insertBack(currCredits.get(i));
		return newPensum;
	}
}
