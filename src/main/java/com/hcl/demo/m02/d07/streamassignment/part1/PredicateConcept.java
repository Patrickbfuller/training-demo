package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.hcl.demo.m02.d07.streamassignment.part1.entity.Symbol;

public class PredicateConcept {

	public static void main(String[] args) {
		
		List<Symbol> symbols = IntStream.range(0, 10)
				.parallel()
				.mapToObj(n -> {
					char shape = (char) (Math.random() * 255);
					byte color = (byte) (Math.random() * 255);
					return new Symbol(shape, color);
				})
				.collect(Collectors.toList());
		
		for (Symbol s : symbols) {
			System.out.println(s);
		}
		
		System.out.println("Alphabetic shapes:");
		
		symbols.parallelStream()
			.filter(s -> Character.isAlphabetic(s.getShape()))
			.forEach(s -> System.out.print(s.getShape()));
		
	}

}
