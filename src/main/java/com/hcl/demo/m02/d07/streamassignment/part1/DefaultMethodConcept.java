package com.hcl.demo.m02.d07.streamassignment.part1;

public class DefaultMethodConcept {

	@FunctionalInterface
	public interface CustomStringMeasurer {

		public int measureString(String s);

		default boolean hasWhitespace(String s) {
			return s.contains(" ");
		}

	}

	public static void main(String[] args) {

		CustomStringMeasurer stringMeasurer = s -> {
			int count = 0;
			for (char c : s.toCharArray()) {
				if (Character.isAlphabetic(c))
					count++;
			}
			return count;
		};
		
		String testString = "How sweet the sound.";
		
		System.out.println("String: " + testString);
		
		System.out.println("Length: " + testString.length());
		
		System.out.println("Has Whitespace?: " + stringMeasurer.hasWhitespace(testString));
		
		System.out.println("Alphabet Count: " + stringMeasurer.measureString(testString));

	}

}
