package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalConcept {
	
	public static void main(String[] args) {
		
		IntStream stream1 = IntStream.range(0, 10);
		IntStream stream2 = IntStream.range(0, 20);
		
		OptionalInt optionalSmallestGreaterThanTen = stream1.filter(x -> x > 10).min();
		
		System.out.println("First optional: " + optionalSmallestGreaterThanTen);
		System.out.println("Has a value? " + optionalSmallestGreaterThanTen.isPresent());
		
		optionalSmallestGreaterThanTen = stream2.filter(x -> x > 10).min();
		
		System.out.println("Second optional: " + optionalSmallestGreaterThanTen.isPresent());
		System.out.println("Contained value " + optionalSmallestGreaterThanTen.getAsInt());

	}

}
