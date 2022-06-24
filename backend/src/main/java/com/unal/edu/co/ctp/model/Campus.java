package com.unal.edu.co.ctp.model;

import java.util.ArrayList;

public class Campus {

	private String name;
	private ArrayList<Degree> degrees;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void insertDegree(Degree degree) {
		this.degrees.add(degree);
	}

	public ArrayList<Degree> getDegrees() {
		return this.degrees;
	}

}
