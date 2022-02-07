package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.StringTokenizer;

public class InterfaceStaticConcept {
	
	interface Formatter {
		
		public String formatCustom(String s);
		
		static String formatKebab(String s) {
			StringTokenizer st = new StringTokenizer(s, " ");
			StringBuilder sb = new StringBuilder();
			while (st.hasMoreTokens()) {
				sb.append(st.nextToken().toLowerCase());
				if (st.hasMoreTokens())
					sb.append("-");
			}
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) {
		
		Formatter formatter = s -> {
			return "[" + s.replaceAll(" ", "]\t[").toUpperCase() + "]";
		};
		
		String testString = "My favorite movies";
		
		System.out.println("Test String: " + testString);
		
		System.out.println("Static method: " + Formatter.formatKebab(testString));
		
		System.out.println("Custom method: " + formatter.formatCustom(testString));
		
	}

}
