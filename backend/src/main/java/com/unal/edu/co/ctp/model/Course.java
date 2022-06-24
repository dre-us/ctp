package com.unal.edu.co.ctp.model;

import java.util.ArrayList;

public class Course implements Comparable<Course> {

	private Integer id;
	private String name;
	private Integer credits;
	private Boolean mandatory;
	private String component;
	private ArrayList<Condition> conditions;

	public Course(Integer id, String name, Integer credits, Boolean mandatory, String component) {
		this.setId(id);
		this.setName(name);
		this.setCredits(credits);
		this.setMandatory(mandatory);
		this.setComponent(component);
		this.conditions = new ArrayList<Condition>();
	}

	public Course(Integer id) {
		this.setCredits(3);
		this.setId(id);
		this.conditions = new ArrayList<Condition>();
	}

	public Course() {
		this.setCredits(3);
		this.conditions = new ArrayList<Condition>();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
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

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Boolean isMandatory() {
			return this.mandatory;
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
		return this.conditions.add(condition);
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

	public CourseDTO getDTO() {
		CourseDTO course = new CourseDTO();
		course.setId(getId());
		course.setName(getName());
		course.setCredits(getCredits());
		course.setComponent(getComponent());
		/*course.setMandatory(isMandatory());
		ArrayList<ConditionDTO> conditionsDTO = new ArrayList<ConditionDTO>();
		for (int i = 0; i < conditions.size(); ++i)
			conditionsDTO.add(conditions.get(i).getDTO());
		course.setConditions(conditionsDTO);*/
		return course;
	}

	@Override
	public String toString() {
		String dataCourse =
			"Codigo: " + getId() + "\n" +
			"Nombre: " + getName() + "\n" +
			"Creditos: " + getCredits() + "\n" +
			"Obligatorio" + (isMandatory() ? "SI" : "NO") + "\n" +
			"Componente: " + getComponent();
		for (int i = 0; i < conditions.size(); ++i) {
			dataCourse += "\nCondicion " + (i + 1) + ": ";
			dataCourse += conditions.get(i).toString();
		}
		return dataCourse;
	}

	@Override
	public boolean equals(Object obj) {
		Course course = (Course) obj;
		return this.getId().equals(course.getId());
	}

	public int compareTo(Course course) {
		if (getId().intValue() == course.getId().intValue()) return 0;
		if (course.getId().intValue() < getId().intValue()) return -1;
		return 1;
	}

}
