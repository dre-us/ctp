package com.unal.ctp.model;
import com.unal.ctp.data_structures.*;

public class Course {

	private String id;
	private String name;
	private Integer credits;
	private String component;
	private ArrayList<Condition> conditions;

	public Course(String id, String name, Integer credits, String component) {
		this.setId(id);
		this.setName(name);
		this.setCredits(credits);
		this.setComponent(component);
		this.conditions = new ArrayList<Condition>();
	}

	public Course(String id) {
		this.setId(id);
		this.conditions = new ArrayList<Condition>();
	}

	public Course() {
		this.conditions = new ArrayList<Condition>();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public void setComponent(String component) {
		if (component.equals("B")) {
			this.component = "Fundamentacion";
		} else if (component.equals("C")) {
			this.component = "Profesional o disciplinar";
		} else if (component.equals("L")) {
			this.component = "Libre eleccion";
		} else {
			this.component = component;
		}
	}

	public String getComponent() {
		return this.component;
	}

	public boolean insertCondition(Condition condition) {
		return this.conditions.insert(condition);
	}

	public boolean deleteCondition(Condition condition) {
		return this.conditions.remove(condition);
	}

	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	public void update(ArrayList<Course> courses) {
		for (int i = 0; i < this.conditions.size(); ++i)
			this.conditions.get(i).update(courses);
	}

	@Override
	public String toString() {
		String dataCourse =
			"Codigo: " + this.id + "\n" +
			"Nombre: " + this.name + "\n" +
			"Creditos: " + this.credits + "\n" +
			"Componente: " + this.component;
		for (int i = 0; i < conditions.size(); ++i) {
			dataCourse += "\nCondicion " + Integer.toString(i + 1) + ": ";
			dataCourse += conditions.get(i).toString();
		}
		return dataCourse;
	}

	@Override
	public boolean equals(Object obj) {
		Course course = (Course) obj;
		return this.getId().equals(course.getId());
	}
}
