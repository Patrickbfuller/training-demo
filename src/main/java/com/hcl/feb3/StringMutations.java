package com.hcl.feb3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringMutations {
	
	public static void main(String[] args) {
		
		String first, middle, last, color, date, fullName;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter first name:");
		first = scanner.next();
		System.out.println("Please enter middle name:");
		middle = scanner.next();
		System.out.println("Please enter last name:");
		last = scanner.next();
		System.out.println("Please enter your favorite date: (dd/mm/yyyy)");
		date = scanner.next();
		System.out.println("Please enter favorite color:");
		color = scanner.next();
		
		scanner.close();
		
		fullName = String.join("_", first, middle, last);
		
		// Part 1
		// f_m_l -> f:m:l
		System.out.println("Full name: " + fullName);
		
		StringBuffer sb1 = new StringBuffer(); 
		
		StringTokenizer tokenizer1 = new StringTokenizer(fullName, "_");
		while (tokenizer1.hasMoreTokens()) {
			sb1.append(tokenizer1.nextToken());
			if (tokenizer1.hasMoreTokens()) {
				sb1.append(":");
			}
		}
		
		System.out.println("Full name with colons: " + sb1.toString());
		
		// Part 2
		// f_m_l -> f m l		
		StringBuffer sb2 = new StringBuffer(); 
		
		StringTokenizer tokenizer2 = new StringTokenizer(fullName, "_");
		while (tokenizer2.hasMoreTokens()) {
			sb2.append(tokenizer2.nextToken());
			if (tokenizer2.hasMoreTokens()) {
				sb2.append(" ");
			}
		}
		
		System.out.println("Full name with colons: " + sb2.toString());
		
		
		// Part 3
		// dd/mm/yyyy
		StringTokenizer tokenizer3 = new StringTokenizer(date, "/");
		String days = tokenizer3.nextToken();
		String months = tokenizer3.nextToken();
		String years = tokenizer3.nextToken();
		System.out.println("Days: " + days);
		System.out.println("Months: " + months);
		System.out.println("Years: " + years);
		

		
		// Part 4
		// f_m_l -> f m l d1 d2
		sb2.append(" ");
		sb2.append(color);
		sb2.append(" ");
		sb2.append(date);
		System.out.println("Full name with data: " + sb2.toString());

	}
}
