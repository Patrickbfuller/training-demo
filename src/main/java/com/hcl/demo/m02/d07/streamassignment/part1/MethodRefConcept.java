package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.stream.IntStream;

public class MethodRefConcept {

	public static void main(String[] args) {

		IntStream.range(1, 11)
			.mapToDouble(n -> (double) n)
			.map(Math::log10)
			.forEach(System.out::println);
	}

}
