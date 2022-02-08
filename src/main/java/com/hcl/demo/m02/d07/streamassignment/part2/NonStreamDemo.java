package com.hcl.demo.m02.d07.streamassignment.part2;

import java.util.LinkedList;
import java.util.List;

import com.hcl.demo.m02.d07.streamassignment.part2.entity.Employee;

/*
 * 2.Implement a Java program with Stream API and without the Stream API,
consider filter condition as for example you had employee list filter the employee records whose salary >1000 $ ,Name Startes with B & D and age > 30 .
 */

public class NonStreamDemo {

	public static void main(String[] args) {

		int n = Employee.demoEmployees.size();

		List<Employee> filteredEmployees = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Employee e = Employee.demoEmployees.get(i);
			// if salary not above cutoff don't add
			if (e.getSalary() <= 1000)
				continue;
			// if age not above cutoff don't add
			if (e.getAge() <= 30)
				continue;
			// Name starts with
			if (e.getName().matches("(?i)[bd].*"))
				filteredEmployees.add(e);
		}

		System.out.println("Filtered Employees: ");
		for (Employee e : filteredEmployees) {
			System.out.println("\t" + e);
		}

	}

}
