package com.freeland.oop.session06abstract.abstract1;

/**
 * Abstract class and its usage
 */
public class MainAnimal {

	public static void main(String[] args) {
		//Animal animal = new Animal(); uncomment to see error
	    Pig myPig = new Pig(); // Create a Pig object
	    myPig.animalSound();
	    myPig.sleep();
	}

}
