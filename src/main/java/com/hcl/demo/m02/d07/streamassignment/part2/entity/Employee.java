package com.hcl.demo.m02.d07.streamassignment.part2.entity;

import java.util.Arrays;
import java.util.List;

public class Employee {

	private String name;
	private int age;
	private int salary;
	
	public static List<Employee> demoEmployees = Arrays.asList(
			new Employee("Amy", 32, 700),
			new Employee("Bob", 31, 1_300),
			new Employee("Cat", 30, 900),
			new Employee("Dan", 28, 1_200),
			new Employee("Eve", 29, 1_400)
			);

	public Employee(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
