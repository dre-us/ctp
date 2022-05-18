package com.unal.ctp.model;

import com.unal.ctp.datastructures.*;

public class Pensum {

	private	ArrayList<Course> courses;
	private ArrayList<Integer> numCourses;
	private ArrayList<String> semesters = new ArrayList<String>();

	public Pensum() {
		this.courses = new ArrayList<Course>();
		this.numCourses = new ArrayList<Integer>();
		semesters.insertBack("PRIMER ");
		semesters.insertBack("SEGUNDO");
		semesters.insertBack("TERCER");
		semesters.insertBack("CUARTO");
		semesters.insertBack("QUINTO");
		semesters.insertBack("SEXTO");
		semesters.insertBack("SÉPTIMO");
		semesters.insertBack("OCTAVO");
		semesters.insertBack("NOVENO");
		semesters.insertBack("DÉCIMO");
		semesters.insertBack("UNDÉCIMO");
		semesters.insertBack("DUOÉCIMO");
		semesters.insertBack("DECIMO-TERCER");
		semesters.insertBack("DECIMO-CUARTO");
		semesters.insertBack("DECIMO-QUINTO");
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
		return courses.find(course) != -1;
	}

	public void insertSemester(ArrayList<Course> newCourses) {
		for (int i = 0; i < newCourses.size(); ++i)
			courses.insertBack(newCourses.get(i));
		numCourses.insertBack(newCourses.size());
	}

	public void removeBack() {
		if (numCourses.size() == 0) return;
		for (int i = 0; i < numCourses.getBack(); ++i)
			courses.deleteBack();
		numCourses.deleteBack();
	}

	public Pensum copy() {
		Pensum newPensum = new Pensum();
		ArrayList<Course> currCourses = this.getCourses();
		ArrayList<Integer> currNumCourses = this.getNumCourses();
		ArrayList<Course> newCourses = new ArrayList<Course>(this.getCourses().size());
		ArrayList<Integer> newNumCourses = new ArrayList<Integer>(this.getNumCourses().size());
		for (int i = 0; i < currCourses.size(); ++i)
			newCourses.insertBack(currCourses.get(i));
		for (int i = 0; i < currNumCourses.size(); ++i)
			newNumCourses.insertBack(currNumCourses.get(i));
		newPensum.setCourses(newCourses);
		newPensum.setNumCourses(newNumCourses);
		return newPensum;
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
			for (int c = 0; c < this.numCourses.get(f); c++) {
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
