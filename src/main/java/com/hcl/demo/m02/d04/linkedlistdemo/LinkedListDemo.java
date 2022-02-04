package com.hcl.demo.m02.d04.linkedlistdemo;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {

		// Non genereic Specific methods
		LinkedList<String> ll = new LinkedList<>();
		
		// Genereic  methods
		// List<String> ll = new LinkedList<>();

		ll.add("Zero");
		ll.add("One");
		ll.add("Two");
		ll.add("Three");
		ll.add("Four");
		
		System.out.println("Starting List" + ll);

		System.out.println("Peek First: " + ll.peekFirst());
		System.out.println("Peek Last: " + ll.peekLast());
		System.out.println("Unchanged List: " + ll);
		
		System.out.println("Remove First: " + ll.removeFirst());
		System.out.println("Modified List: " + ll);
		
		System.out.println("Remove Last: " + ll.removeLast());
		System.out.println("Modified List: " + ll);
		
	}

}
