package com.app.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Animal {

	@Id
	private String name;
	private String scientificName;
	private int age;
	private String birthday;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return this.scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "{" + " name='" + getName() + "'" + ", scientificName='" + getScientificName() + "'" + ", age='"
				+ getAge() + "'" + ", birthday='" + getBirthday() + "'" + "}";
	}

}
