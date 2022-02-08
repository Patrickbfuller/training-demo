package com.hcl.demo.m02.d07.streamassignment.part1.entity;

public class Symbol {

	private char shape;
	private byte color;

	public Symbol(char shape, byte color) {
		super();
		this.shape = shape;
		this.color = color;
	}

	public char getShape() {
		return shape;
	}

	public void setShape(char shape) {
		this.shape = shape;
	}

	public byte getColor() {
		return color;
	}

	public void setColor(byte color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Symbol [shape=" + shape + ", color=" + color + "]";
	}

}
