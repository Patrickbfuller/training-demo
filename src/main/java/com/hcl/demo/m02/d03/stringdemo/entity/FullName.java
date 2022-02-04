package com.hcl.demo.m02.d03.stringdemo.entity;

import com.hcl.demo.m02.d03.stringdemo.exception.LongNameException;

public class FullName {
	
	private String first;
	private String middle;
	private String last;
	private int numberOfChars;
	
	public FullName(String s) throws LongNameException {
		
		if (s.length() > 15) {
			throw new LongNameException();
		}
		
		numberOfChars = s.length();
		String[] names = s.trim().split(" ");
		
		first = names[0];
		last = names[names.length - 1];
		for (int i = 1; i < names.length - 1; i++) {
			middle = String.join(" ", middle, names[i]);
		}
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getMiddle() {
		return middle;
	}
	
	public String getLast() {
		return last;
	}
	
	public int getNumberOfChars() {
		return numberOfChars;
	}

}
