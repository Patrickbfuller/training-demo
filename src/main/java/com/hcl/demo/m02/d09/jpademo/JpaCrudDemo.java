package com.hcl.demo.m02.d09.jpademo;

import java.util.List;

import com.hcl.demo.m02.d09.jpademo.entity.Student;
import com.hcl.demo.m02.d09.jpademo.util.DBUtil;

public class JpaCrudDemo {
	
	static String pad = "  ";

	public static void main(String[] args) {
		
		StringBuilder record = new StringBuilder();
		
		// A - Insert
		record.append("-Inserting first record...\n");
		DBUtil.insert(new Student("Harry", "Potter", "boywholived@hogwarts"));
		recordStudentList(record, DBUtil.getAll());
		
		record.append("-Inserting first record...\n");
		DBUtil.insert(new Student("Dobby", "TheElf", "freeelf@hogwarts"));
		recordStudentList(record, DBUtil.getAll());
		
		
		
		// B - Find particular row
		record.append("-Getting single record with id = 2...\n");
		record.append(pad + DBUtil.getOne(1) + "\n");
		
		// C - Find all
		record.append("-Retrieving all records...\n");
		DBUtil.insert(new Student("Severus", "Snape", "halfbloodprince@hogwarts"));
		recordStudentList(record, DBUtil.getAll());
		
		// D - Update
		record.append("-Updating student with id = 3...\n");
		DBUtil.update(3, new Student("Severus", "Snape", "always@hogwarts"));
		recordStudentList(record, DBUtil.getAll());
		
		// E - Delete
		record.append("-Deleting student with id = 2...\n");
		DBUtil.delete(2);
		recordStudentList(record, DBUtil.getAll());
		
		
		// closing jpa entity manager factory
		DBUtil.shutdown();
		
		System.out.print(record.toString());
		
	}

	public static void recordStudentList(StringBuilder record, List<Student> students) {
		for (Student student : students) {
			record.append(pad + student + "\n");
		}
	}

}
