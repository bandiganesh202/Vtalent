package com.vtalent.insurance.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Year {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String y_name;
public Year() {
	super();
}
public Year(int id, String y_name) {
	super();
	this.id = id;
	this.y_name = y_name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getY_name() {
	return y_name;
}
public void setY_name(String y_name) {
	this.y_name = y_name;
}



}