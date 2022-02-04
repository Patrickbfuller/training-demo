package com.hcl.demo.m02.d02.exceptiondemo;

import java.util.Scanner;

import com.hcl.demo.m02.d02.exceptiondemo.entity.Account;
import com.hcl.demo.m02.d02.exceptiondemo.exception.InsufficientBalanceException;

/*
 * Write a Java program to handle exception handling mechanism through user-oriented exception handling
 *  let's say you deposit 600 $ in favor saving account then you withdraw 100 $ from your account,
 *  now you had 500 $ remining with you,
 *  but if you want to withdraw 600 $ again ,
 *  then your program should throw InSufficentBalance Exception
 */

public class BankExceptionCLI {
	
	public static void main(String[] args) {
		
		Account account = new Account();
		
		Scanner scanner = new Scanner(System.in);
		
		char choice = '\u0000';
		// Loop menu
		while (choice != '3') {
			
			// Display menu 
			System.out.println(
					String.format(
					"***************************\n"
					+ "Current Balance is: $%.2f\n"
					+ "Enter\n"
					+ "\t(1) to deposit\n"
					+ "\t(2) to withdraw\n"
					+ "\t(3) to exit",
					account.getBalance()
					));
		
			// Receive choice
			choice = scanner.next().charAt(0);
			
			// Deposit
			if (choice == '1') {
				System.out.print("Okay, Deposit: How much do you want to deposit? $");
				double amount = scanner.nextDouble();
				account.deposit(amount);
			// Withdraw
			} else if (choice == '2') {
				System.out.print("Okay, Withdraw: How much do you want to withdraw? $");
				double amount = scanner.nextDouble();
				try {
					account.withdraw(amount);
				} catch (InsufficientBalanceException e) {
					System.out.println(e + "\nUnable to process transaction...");
				}
			// Respond to choice other than '1', '2', or '3'
			} else if (choice != '3'){
				System.out.println("Choice unrecognized. Please enter 1, 2, or 0");
			}
		}
		scanner.close();
		System.out.println("Thank you. Goodbye!");
	}

}
