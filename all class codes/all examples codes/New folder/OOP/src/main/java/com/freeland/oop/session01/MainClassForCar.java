package com.freeland.oop.session01;

/**
 * welcome to oop world
 */
public class MainClassForCar {

	public static void main(String[] args) {
		Car ford = new Car("Ford", "Focus", "red");
		Car toyota = new Car("Toyota", "Auris", "blue");
		Car golf = new Car("Volkswagen", "Golf", "green");
		
		ford.setColor("blue");
		
		ford.increaseSpeed(10);
		System.out.println( ford );  //describe why print ford works toString
		
		toyota.increaseSpeed(20);
		System.out.println(toyota);
		
		golf.increaseSpeed(30);
		golf.decreaseSpeed(12);
		System.out.println(golf);

	}

}
