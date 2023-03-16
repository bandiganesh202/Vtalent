package com.vtalent.insurance.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ActualYear {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String y_id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getY_id() {
		return y_id;
	}
	public void setY_id(String y_id) {
		this.y_id = y_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
