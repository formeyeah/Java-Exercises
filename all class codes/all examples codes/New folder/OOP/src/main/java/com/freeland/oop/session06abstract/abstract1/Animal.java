package com.freeland.oop.session06abstract.abstract1;

//Abstract class
public abstract class Animal {

	// Abstract method (does not have a body)
	public abstract void animalSound();

	public void sleep() {
		System.out.println("Zzz");
	}
	
	public void walk() {
		System.out.println("I can walk");
	}

}
