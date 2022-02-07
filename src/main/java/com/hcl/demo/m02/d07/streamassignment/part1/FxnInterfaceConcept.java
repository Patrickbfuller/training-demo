package com.hcl.demo.m02.d07.streamassignment.part1;

import java.util.stream.IntStream;

public class FxnInterfaceConcept {

	@FunctionalInterface
	interface CustomIntToStringChanger {

		public String intToString(int n);

	}

	public static void main(String[] args) {

		IntStream.range(1, 5).mapToObj(n -> applyFunctionalInterface(n, m -> {
			String s = String.valueOf(m);
			StringBuilder sb = new StringBuilder(s);
			for (int i = 1; i < m; i++) {
				sb.append(s);
			}
			return sb.toString();
		})).forEach(System.out::println);;

	}

	public static String applyFunctionalInterface(int n, CustomIntToStringChanger customIntToStringChanger) {

		return customIntToStringChanger.intToString(n);

	}

}
