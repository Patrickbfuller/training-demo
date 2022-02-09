package com.hcl.demo.m02.d09.jpademo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "student")
@Entity(name = "student")
@Data
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String first, String last, String email) {
		super();
		firstName = first;
		lastName = last;
		this.email = email;
	}

}
