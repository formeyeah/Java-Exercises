package com.freeland.oop.session03extends;

/**
 * use extend to create new class which inheritance from others
 */
public class MainClassForCar {

	public static void main(String[] args) {
		Car ford = new Car("Ford", "Focus", "red");
		LuxryCar bmw = new LuxryCar("BMW", "BMW i7", "blue", 220);
		
		ford.increaseSpeed(10);
		
		bmw.increaseSpeed(10);
		bmw.canWorkwith(30);

	}

}
