package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.stream.LongStream;

public class ParallelConcept {

	public static void main(String[] args) {

		long n = 100_000_000;
		long divisor = 10_000_000;
		
		long a, b;

		// Time for loop
		a = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			if (i % divisor == 0)
				System.out.print(i + " ");

		}
		b = System.currentTimeMillis();

		System.out.println("\nMillisecond for 'FOR LOOP': " + (b - a));

		// Time stream
		a = System.currentTimeMillis();
		LongStream.range(0, n)
			.filter(longValue -> longValue % divisor == 0)
			.forEach(longValue -> System.out.print(longValue + " "));
		b = System.currentTimeMillis();

		System.out.println("\nMillisecond for 'STREAM': " + (b - a));

		// Time parallel stream 
		a = System.currentTimeMillis();
		LongStream.range(0, n).parallel()
			.filter(longValue -> longValue % divisor == 0)
			.forEach(longValue -> System.out.print(longValue + " "));
		;
		b = System.currentTimeMillis();

		System.out.println("\nMillisecond for 'PARALLEL STREAM': " + (b - a));
		
		// Time parallel stream unordered
		a = System.currentTimeMillis();
		LongStream.range(0, n).parallel()
			.filter(longValue -> longValue % divisor == 0)
			.forEachOrdered(longValue -> System.out.print(longValue + " "));
		;
		b = System.currentTimeMillis();

		System.out.println("\nMillisecond for 'PARALLEL STREAM W ORDERED FOR EACH': " + (b - a));
				
	}
	
	

}
