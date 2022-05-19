package com.unal.ctp.model;

import com.unal.ctp.datastructures.*;

public class PensumChild extends Pensum {

    private ArrayList<Course> courses;
    private ArrayList<Integer> num_courses;
    private ArrayList<String> semesters = new ArrayList<String>();

    //CONSTRUCTOR
    public PensumChild(ArrayList<Integer> num_courses, ArrayList<Course> courses) {
        this.courses = courses;
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

    this.num_courses = num_courses;
    }

    public PensumChild() {
        this.courses = new ArrayList<Course>();
        this.num_courses = new ArrayList<Integer>();
    }

    //METHODS
    public void printPensum(){

        int max_courses = 0;

        for(int i = 0; i < this.num_courses.size(); i++){
            if(this.num_courses.get(i) > max_courses){
                max_courses = this.num_courses.get(i);
            }
        }

        String pensumMatrix[][] = new String[max_courses+1][this.num_courses.size()];

        int courseCount = 0;
        for (int f = 0; f < this.num_courses.size(); f++) {
            pensumMatrix[0][f] = semesters.get(f);
            for (int c = 0; c < this.num_courses.get(f); c++) {
                pensumMatrix[c+1][f] = this.courses.get(courseCount).getName();
                courseCount++;

          }
        }
        for (int x=0; x < max_courses; x++) {
            System.out.print("|");
            for (int y=0; y < this.num_courses.size(); y++) {
                if(pensumMatrix[x][y] == null || pensumMatrix[x][y].equals("")){
                    pensumMatrix[x][y] = "       ";
                }else{
                    if (pensumMatrix[x][y].length() < 7) {
                        System.out.print (pensumMatrix[x][y]);
                        for (int k = pensumMatrix[x][y].length(); k < 7; ++k)
                            System.out.print(" ");
                    } else {
                        System.out.print (pensumMatrix[x][y].substring(0, 7));
                    }
                }
              if (y!=pensumMatrix[x].length-1) System.out.print("       ");
            }
            System.out.println("|");
        }
    }

    public void insertSemester(ArrayList<Course> courses){
	for (int i = 0; i < courses.size(); ++i)
		this.courses.insertBack(courses.get(i));
	this.num_courses.insertBack(courses.size());
    }

    public void removeBack() {
	if (this.num_courses.size() == 0) return;
	for (int i = 0; i < num_courses.getBack(); ++i)
		courses.deleteBack();
	num_courses.deleteBack();
    }

    public boolean contains(Course course) {
	return this.courses.find(course) != -1;
    }

    //GETTERS AND SETTERS
    public ArrayList<Integer> getNumCourses() {
        return num_courses;
    }


    public void setNumCourses(ArrayList<Integer> num_courses) {
        this.num_courses = num_courses;
    }


    public ArrayList<Course> getCourses() {
        return courses;
    }


    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

        //TO STRING()
    @Override
    public String toString() {
        return "PensumChild [courses=" + courses + ", num_courses=" + num_courses + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Pensum copy() {
	Pensum pensum = new Pensum();
	ArrayList<Course> newCourses = new ArrayList<Course>();
	ArrayList<Integer> newNumCourses = new ArrayList<Integer>();
	for (int i = 0; i < this.courses.size(); ++i)
		newCourses.insertBack(this.courses.get(i));
	for (int i = 0; i < this.num_courses.size(); ++i)
		newNumCourses.insertBack(this.num_courses.get(i));
	pensum.setCourses(newCourses);
	pensum.setNumCourses(newNumCourses);
	return pensum;
    }
}
