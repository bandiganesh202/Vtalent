package com.vtalent.insurance.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="company_name")
public class MakeOfCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int y_id;
	private int a_id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getY_id() {
		return y_id;
	}
	public void setY_id(int y_id) {
		this.y_id = y_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setActualYearId(int int1) {
		// TODO Auto-generated method stub
		
	}
	 
}
