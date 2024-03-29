package com.hcl.demo.m02.d04.hospitaldemo.entity;

public class Doctor implements Comparable<Doctor> {

	private int id;
	private String name;
	private String specialty;

	public Doctor(int id, String name, String specialty) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int compareTo(Doctor other) {
		return this.id - other.id;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialty=" + specialty + "]";
	}

}
