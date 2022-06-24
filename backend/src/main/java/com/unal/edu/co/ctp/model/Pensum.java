package com.unal.edu.co.ctp.model;

import java.util.ArrayList;

public class Pensum {

	private	ArrayList<Course> courses;
	private ArrayList<Integer> numCourses;
	private ArrayList<String> semesters = new ArrayList<String>();

	public Pensum() {
		this.courses = new ArrayList<Course>();
		this.numCourses = new ArrayList<Integer>();
		semesters.add("PRIMER ");
		semesters.add("SEGUNDO");
		semesters.add("TERCER");
		semesters.add("CUARTO");
		semesters.add("QUINTO");
		semesters.add("SEXTO");
		semesters.add("SÉPTIMO");
		semesters.add("OCTAVO");
		semesters.add("NOVENO");
		semesters.add("DÉCIMO");
		semesters.add("UNDÉCIMO");
		semesters.add("DUOÉCIMO");
		semesters.add("DECIMO-TERCER");
		semesters.add("DECIMO-CUARTO");
		semesters.add("DECIMO-QUINTO");
		semesters.add("DECIMO-SEXTO");
		semesters.add("DECIMO-SEPTIMO");
		semesters.add("DECIMO-OCTAVO");
		semesters.add("DECIMO-NOVENO");
		semesters.add("VIGESIMO");
	}

	public void setCourses(ArrayList<Course> newCourses) {
		this.courses = newCourses;
	}

	public void setNumCourses(ArrayList<Integer> newNumCourses) {
		this.numCourses = newNumCourses;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public ArrayList<Integer> getNumCourses() {
		return numCourses;
	}

	public boolean contains(Course course) {
		return courses.indexOf(course) != -1;
	}

	public void insertSemester(ArrayList<Course> newCourses) {
		for (int i = 0; i < newCourses.size(); ++i)
			courses.add(newCourses.get(i));
		numCourses.add(newCourses.size());
	}

	public void removeBack() {
		if (numCourses.size() == 0) return;
		for (int i = 0; i < numCourses.get(numCourses.size() - 1); ++i)
			courses.remove(courses.size() - 1);
		numCourses.remove(numCourses.size() - 1);
	}

	public PensumDTO getDTO() {
		PensumDTO pensum = new PensumDTO();
		ArrayList<ArrayList<CourseDTO>> semesters = new ArrayList<ArrayList<CourseDTO>>();
		int idx = 0;
		for (int i = 0; i < numCourses.size(); ++i) {
			int k = numCourses.get(i);
			ArrayList<CourseDTO> semester = new ArrayList<CourseDTO>();
			for (int j = 0; j < k; ++j)
				semester.add(courses.get(idx++).getDTO());	
			semesters.add(semester);
		}
		pensum.setPensum(semesters);
		pensum.setSemesters(numCourses.size());
		return pensum;
	}

	public void printPensum(){

		int maxCourses = 0;

		for(int i = 0; i < this.numCourses.size(); i++){
			if(this.numCourses.get(i) > maxCourses)
				maxCourses = this.numCourses.get(i);
		}

		String pensumMatrix[][] = new String[maxCourses+1][this.numCourses.size()];

		int courseCount = 0;
		for (int f = 0; f < this.numCourses.size(); f++) {
			pensumMatrix[0][f] = semesters.get(f);
			for (int c = 0; c < this.numCourses.get(f).intValue(); c++) {
				pensumMatrix[c+1][f] = this.courses.get(courseCount).getName();
				courseCount++;
			}
		}
		for (int x=0; x < maxCourses + 1; x++) {
			System.out.print("|");
			for (int y=0; y < this.numCourses.size(); y++) {
				if (pensumMatrix[x][y] == null || pensumMatrix[x][y].equals("")){
					System.out.print("       ");
				} else {
					if (pensumMatrix[x][y].length() < 7) {
						System.out.print (pensumMatrix[x][y]);
						for (int k = pensumMatrix[x][y].length(); k < 7; ++k)
							System.out.print(" ");
					} else {
						System.out.print(pensumMatrix[x][y].substring(0, 7));
					}
				}
				if (y!=this.numCourses.size()-1) System.out.print("       ");
			}
			System.out.println("|");
		}
	}

}
