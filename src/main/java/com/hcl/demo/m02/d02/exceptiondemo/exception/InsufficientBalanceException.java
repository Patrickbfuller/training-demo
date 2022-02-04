package com.hcl.demo.m02.d02.exceptiondemo.exception;

public class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException() {}

	public InsufficientBalanceException(String message) {System.out.println(message);}
	
	public String toString() {
		return "BALANCE IS INSUFFICIENT";
	}
}