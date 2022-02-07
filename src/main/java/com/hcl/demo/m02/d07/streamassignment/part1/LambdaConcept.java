package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.stream.IntStream;

public class LambdaConcept {

	public static void main(String[] args) {

		IntStream.range(0, 10).forEach(n -> System.out.print(n % 3));

	}

}
