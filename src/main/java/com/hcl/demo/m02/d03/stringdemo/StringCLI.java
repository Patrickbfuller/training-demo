package com.hcl.demo.m02.d03.stringdemo;

import java.util.Scanner;

import com.hcl.demo.m02.d02.exceptiondemo.exception.InsufficientBalanceException;
import com.hcl.demo.m02.d03.stringdemo.entity.FullName;
import com.hcl.demo.m02.d03.stringdemo.exception.LongNameException;

public class StringCLI {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char choice = 'y';
		// Loop menu
		while (choice != 'n') {

			// Respond to 'y'
			if (choice == 'y') {
				// Prompt user
				System.out.print("Please enter your full name: ");
				
				FullName fullName;
				try {
					// Collect name and display features
					fullName = new FullName(scanner.nextLine());
					System.out.println(String.format(
							"First: %s\n"
							+ "Middle: %s\n"
							+ "Last: %s\n"
							+ "There are %d characters in this name.",
							fullName.getFirst(),
							fullName.getMiddle(),
							fullName.getLast(),
							fullName.getNumberOfChars()
							));
				} catch (LongNameException e) {
					System.out.println(e);
				}
				
				System.out.println("Would you like to enter another name? (y/n)");
				// Clear scanner and receive choice
				choice = Character.toLowerCase(scanner.nextLine().charAt(0));
			
			// Respond to option other than 'y' or 'n'
			} else if (choice != 'n') {
				System.out.println("Choice unrecognized. Please enter y or n");
				System.out.println("Would you like to enter another name?");
				choice = Character.toLowerCase(scanner.nextLine().charAt(0));
			}
		}
		scanner.close();
		System.out.println("Thank you. Goodbye!");
	}
}
