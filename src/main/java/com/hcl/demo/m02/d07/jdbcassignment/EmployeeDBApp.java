package com.hcl.demo.m02.d07.jdbcassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hcl.demo.m02.d07.jdbcassignment.entity.Employee;
import com.hcl.demo.m02.d07.jdbcassignment.util.DBUtil;
import com.hcl.demo.m02.d07.jdbcassignment.util.CLIUtil;

/*

Write a Employee Management application to do the given below operations. Assume Employee has attributes as EmpID,EmpName,DOB,Salary,Age
1.To Insert the record in Employee DB input through command line arguments.
2.To retrieve all the Employee information.
3.To retrieve any employee record input given through command line arguments.
4.To update any particular employee record  input given through command line arguments.
5.To delete any particular employee record  input given through command line arguments.
6.Lets say you retrieve all the employee information then you need to filter the records by the condition sal>5000 and employee name starts with B and age >21

 */

public class EmployeeDBApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		try (Connection conn = DBUtil.getConnection()) {
			
			PreparedStatement preparedInsert = conn.prepareStatement(DBUtil.preparedInsertSQL);
			PreparedStatement selectAllStatement = conn.prepareStatement(DBUtil.preparedSelectAll);
			PreparedStatement selectByIdStatement = conn.prepareStatement(DBUtil.preparedSelectById);
			PreparedStatement removeByIdStatement = conn.prepareStatement(DBUtil.preparedRemoveById);
			
			Map<String, PreparedStatement> updateStatements = new HashMap<>();
			updateStatements.put("name", conn.prepareStatement(DBUtil.preparedUpdateNameById));
			updateStatements.put("dob", conn.prepareStatement(DBUtil.preparedUpdateDobById));
			updateStatements.put("salary", conn.prepareStatement(DBUtil.preparedUpdateSalaryById));
			updateStatements.put("age", conn.prepareStatement(DBUtil.preparedUpdateAgeById));
			
			ResultSet rs;
			int id;
			
			
			// loop menu
			int choice = 0;
			while (choice != 7) {
				System.out.println(CLIUtil.mainMenu);
				choice = scanner.nextInt();
				switch (choice) {
				
				// 1 insert
				case 1:
					Employee newEmp = CLIUtil.getEmployeeFromUser(scanner);
					DBUtil.insertEmployee(preparedInsert, newEmp);
					break;
	
				// 2 retrieveAll
				case 2:
					rs = selectAllStatement.executeQuery();
					CLIUtil.displayResultSet(rs);
					break;
	
				// 3 retrieve
				case 3:
					System.out.println("Which record do you want to retrieve?");
					id = CLIUtil.getIdFromUser(scanner);
					selectByIdStatement.setInt(1, id);
					rs = selectByIdStatement.executeQuery();
					CLIUtil.displayResultSet(rs);
					break;
	
				// 4 update
				case 4:
					System.out.println("Which record do you want to update?");
					id = CLIUtil.getIdFromUser(scanner);
					String fieldName = CLIUtil.getFieldNameFromUser(scanner);
					String newValue = CLIUtil.getNewValue(scanner, fieldName);
					DBUtil.updateEmployee(updateStatements.get(fieldName), newValue, id);
					break;
	
				// 5 delete
				case 5:
					System.out.println("Which record do you want to delete?");
					id = CLIUtil.getIdFromUser(scanner);
					DBUtil.removeEmployeById(removeByIdStatement, id);
					break;
	
				// 6 retrieve and show filtered
				case 6:
					rs = selectAllStatement.executeQuery();
					CLIUtil.displayResultSetFiltered(rs,
							e -> e.getAge() > 21 && e.getSalary() > 5000 && e.getName().startsWith("B"));
					break;

				// 7 exit - do nothing; let loop end
				}
		}
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		scanner.close();
		System.out.println("Good Bye!");

	}

}
