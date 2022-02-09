package com.hcl.demo.m02.d07.jdbcassignment.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;

import com.hcl.demo.m02.d07.jdbcassignment.entity.Employee;

public class CLIUtil {
	
	public static String mainMenu = "- MAIN MENU -\n"
			+ "Select from below:\n"
			+ "(1) to add employee...\n"
			+ "(2) to view all employees...\n"
			+ "(3) to view single employee...\n"
			+ "(4) to update an employee...\n"
			+ "(5) to remove an employee...\n"
			+ "(6) to see filtered results...\n"
			+ "(7) to exit...";
	
	public static String updateFieldMenu = "Which field do you want to update?\n"
			+ "(1) for Name...\n"
			+ "(2) for D.O.B...\n"
			+ "(3) for Salary...\n"
			+ "(4) for Age...";
	
	public static Employee getEmployeeFromUser(Scanner scanner) {
		
		scanner.nextLine();
		
		System.out.print("Enter employee's name: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter employee's date of birth: ");
		String dob = scanner.nextLine();

		System.out.print("Enter employee's salary: ");
		int salary = scanner.nextInt();

		System.out.print("Enter employee's age: ");
		int age = scanner.nextInt();
		

		return new Employee(name, dob, salary, age);
	}
	
	public static int getIdFromUser(Scanner scanner) {
		scanner.nextLine();
		System.out.print("Enter id of employee: ");
		int n = scanner.nextInt();		
		return n;
	}
	
	public static String getFieldNameFromUser(Scanner scanner) {
		System.out.println(updateFieldMenu);
		String[] fields = {"name", "dob", "salary", "age"};
		int choice = scanner.nextInt();
		return fields[choice - 1];
	}
	
	public static String getNewValue(Scanner scanner, String fieldName) {
		scanner.nextLine();
		System.out.println("Enter new value for " + fieldName + ": ");
		return scanner.nextLine();
	}
	
	public static void displayResultSet(ResultSet rs) throws SQLException {
		System.out.println("- RESULTS -");
		while (rs.next()) {
			Employee e = DBUtil.extractEmployeeFromResultSetRow(rs);
			displayEmployeeRecord(e);
		}
	}

	public static void displayResultSetFiltered(ResultSet rs, Predicate<Employee> p) throws SQLException {
		System.out.println("- FILTERED RESULTS -");
		while (rs.next()) {
			Employee e = DBUtil.extractEmployeeFromResultSetRow(rs);
			if (p.test(e))
				displayEmployeeRecord(e);
		}
	}
	
	public static void displayEmployeeRecord(Employee e) {
		System.out.println(String.format(
				"%4d %-20s%10s%8d%4d",
				e.getId(),
				e.getName(),
				e.getDob(),
				e.getSalary(),
				e.getAge()));
	}
	


}
