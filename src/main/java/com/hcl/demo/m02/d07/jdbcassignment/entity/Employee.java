package com.hcl.demo.m02.d07.jdbcassignment.entity;

import java.util.Arrays;
import java.util.List;

public class Employee {

	/*
	 * Assume Employee has attributes as EmpID,EmpName,DOB,Salary,Age
	 */

	private int id;
	private String name;
	private String dob;
	private int salary;
	private int age;
	
	public static List<Employee> demoEmployees = Arrays.asList(
			new Employee("Brie", "01/02/2000", 5001, 32),
			new Employee("Bob", "02/03/2000", 5800, 39),
			new Employee("Bill", "03/04/2000", 4700, 31),
			new Employee("Dan", "04/05/2000", 5000, 20),
			new Employee("Dave", "05/06/2000", 5000, 32),
			new Employee("Cate", "06/07/2000", 6000, 35)
			);

	public Employee(int id, String name, String dob, int salary, int age) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.age = age;
	}
	
	public Employee(String name, String dob, int salary, int age) {
		super();
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.age = age;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", age=" + age + "]";
	}

}
