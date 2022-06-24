package com.unal.edu.co.ctp.model;

import java.util.List;
import java.util.ArrayList;

public class CourseDTO {

	private Integer id;
	private String name;
	private Integer credits;
	//private Boolean mandatory;
	private String component;
	private Boolean approved;
	//private ArrayList<ConditionDTO> conditions;

	public CourseDTO() {
		this.approved = false;
		//this.conditions = new ArrayList<ConditionDTO>();
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
	/*
	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Boolean isMandatory() {
			return this.mandatory;
	}
	*/
	public void setComponent(String component) {
		this.component = component;
	}

	public String getComponent() {
		return this.component;
	}
	/*
	public void setConditions(ArrayList<ConditionDTO> conditions) {
		this.conditions = conditions;
	}

	public ArrayList<ConditionDTO> getConditions() {
		return conditions;
	}
	*/
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getApproved() {
		return approved;
	}
}
