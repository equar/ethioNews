package com.ethionews.model;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String model;
	private int year;
	private String color;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
