package com.hcl.demo.m02.d07.jdbcassignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hcl.demo.m02.d07.jdbcassignment.entity.Employee;

public class DBUtil {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/jdbc_demo?allowPublicKeyRetrieval=true&useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "demopass";
	
	private static String dropIfExistsStatement = "DROP TABLE IF EXISTS employee;";
	private static String createStatement = "CREATE TABLE `jdbc_demo`.`employee` (\n"
			+ "  `id` INT NOT NULL AUTO_INCREMENT,\n"
			+ "  `name` VARCHAR(45) NULL,\n"
			+ "  `dob` VARCHAR(45) NULL,\n"
			+ "  `salary` INT NULL,\n"
			+ "  `age` INT NULL,\n"
			+ "  PRIMARY KEY (`id`));";
	
	public static String preparedInsertSQL = "INSERT INTO employee (name, dob, salary, age) VALUES (?, ?, ?, ?);";
	public static String preparedSelectAll = "SELECT * FROM employee";
	public static String preparedSelectById = "SELECT * FROM employee WHERE id=?";
	public static String preparedUpdateNameById = "UPDATE employee SET name = ? WHERE id=?";
	public static String preparedUpdateDobById = "UPDATE employee SET dob = ? WHERE id=?";
	public static String preparedUpdateSalaryById = "UPDATE employee SET salary = ? WHERE id=?";
	public static String preparedUpdateAgeById = "UPDATE employee SET age = ? WHERE id=?";
	public static String preparedRemoveById = "DELETE FROM employee WHERE id=?";
	

	

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

			resetSchema(conn);
			addStarterData(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	static void resetSchema(Connection conn) throws SQLException {
		Statement statement = conn.createStatement();
		statement.execute(dropIfExistsStatement);
		statement.execute(createStatement);
	}
	
	static void addStarterData(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(preparedInsertSQL);
		for (Employee e : Employee.demoEmployees) {
			insertEmployee(ps, e);
		}
	}
	
	public static void insertEmployee(PreparedStatement ps, Employee e) throws SQLException {
		ps.setString(1, e.getName());
		ps.setString(2, e.getDob());
		ps.setInt(3, e.getSalary());
		ps.setInt(4, e.getAge());
		
		ps.executeUpdate();
	}
	
	public static void updateEmployee(PreparedStatement ps, String value, int id) throws SQLException {
		ps.setString(1, value);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public static void removeEmployeById(PreparedStatement ps, int id) throws SQLException {
		
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public static Employee extractEmployeeFromResultSetRow(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String dob = rs.getString("dob");
		int salary = rs.getInt("salary");
		int age = rs.getInt("age");

		return new Employee(id, name, dob, salary, age);
	}

}
