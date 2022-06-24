package com.unal.edu.co.ctp.model;

import java.util.ArrayList;

public class PensumDTO {

	private int semesters;
	private	ArrayList<ArrayList<CourseDTO>> pensum;

	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}

	public int getSemesters() {
		return semesters;
	}

	public ArrayList<ArrayList<CourseDTO>> getPensum() {
		return pensum;
	}

	public void setPensum(ArrayList<ArrayList<CourseDTO>> pensum) {
		this.pensum = pensum;
	}
}
