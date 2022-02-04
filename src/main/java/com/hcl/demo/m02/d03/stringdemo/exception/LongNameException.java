package com.hcl.demo.m02.d03.stringdemo.exception;

public class LongNameException extends Exception {
	
	public LongNameException() {}
	
	public LongNameException(String message) {
		System.out.println(message);
	}
	
	public String toString() {
		return "The name has more than 15 characters!";
	}

}
