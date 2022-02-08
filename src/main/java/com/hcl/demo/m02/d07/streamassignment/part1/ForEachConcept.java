package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.stream.IntStream;

public class ForEachConcept {
	
	public static void main(String[] args) {
		
		StringBuffer fakeTextFile = new StringBuffer();
		
		int m = 13;
		
		IntStream.range(50, 100).forEach( n -> {
			if (n % m == 0) {
				writeToFakeFile("\n" + n + " is divisible by " + m + "\n", fakeTextFile);
			} else { 
				writeToFakeFile(String.valueOf(n) + ", ", fakeTextFile);
			}
		});
		
		System.out.print(fakeTextFile);
		
	}
	
	static void writeToFakeFile(String text, StringBuffer target) {
		target.append(text);
	}

}
