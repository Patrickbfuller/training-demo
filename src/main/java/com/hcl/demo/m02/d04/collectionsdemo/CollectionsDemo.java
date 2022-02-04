package com.hcl.demo.m02.d04.collectionsdemo;

import java.util.ArrayList;
import java.util.List;

import com.hcl.demo.m02.d04.collectionsdemo.entity.Employee;

public class CollectionsDemo {

	public static void main(String[] args) {

		// Collection of employees
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1, "Martin", "Selma"));
		employees.add(new Employee(2, "Winston", "London"));
		employees.add(new Employee(3, "Abraham", "DC"));

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
