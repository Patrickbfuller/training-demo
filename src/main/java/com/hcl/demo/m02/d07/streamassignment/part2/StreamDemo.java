package com.hcl.demo.m02.d07.streamassignment.part2;

import java.util.List;
import java.util.stream.Collectors;

import com.hcl.demo.m02.d07.streamassignment.part2.entity.Employee;

/*
 * 2.Implement a Java program with Stream API and without the Stream API,
consider filter condition as for example you had employee list filter the employee records whose salary >1000 $ ,Name Startes with B & D and age > 30 .
 */

public class StreamDemo {
	
	public static void main(String[] args) {
		List<Employee> filteredEmployees = Employee.demoEmployees.stream()
				.filter(e -> e.getAge() > 30)
				.filter(e -> e.getSalary() > 1_000)
				.filter(e -> e.getName().matches("(?i)[bd].*"))
				.collect(Collectors.toList());
		
		System.out.println("Filtered Employees: ");
		for (Employee e : filteredEmployees) {
			System.out.println("\t" + e);
		}
	}

}
