package com.hcl.exceptiondemo.entity;

import com.hcl.exceptiondemo.exception.InsufficientBalanceException;

public class Account {
	
	private double balance = 0;
	
	public double getBalance() {
		return Math.round(balance * 100.0) / 100.0;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance)
			throw new InsufficientBalanceException();
		balance -= amount;
	}

}
