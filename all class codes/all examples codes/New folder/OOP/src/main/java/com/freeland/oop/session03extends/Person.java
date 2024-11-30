package com.freeland.oop.session03extends;

public class Person {
	private String name;
	
	
	public Person(String name) {
		super();
		this.name = name;
	}


	public void printMyName() {
		System.out.println("This is my" + name);
	}
}
