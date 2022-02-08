package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsConcept {

	public static void main(String[] args) {

		Set<Integer> strings = IntStream.range(0, 10)
				.map(n -> n % 6)
				.mapToObj(n -> (Integer) n)
				.collect(Collectors.toSet());

		System.out.println(strings);

	}

}
