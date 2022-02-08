package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.PrimitiveIterator.OfInt;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class BiFunctionConcept {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, String> concatenateIntegers = (n1, n2) -> {
			return String.valueOf(n1) + n2;
		};
		
		OfInt s1 = IntStream.range(0, 10).iterator();
		OfInt s2 = IntStream.range(100, 110).iterator();

		while (s1.hasNext() && s2.hasNext()) {
			System.out.println(concatenateIntegers.apply(s1.next(), s2.next()));
		}

	}

}
