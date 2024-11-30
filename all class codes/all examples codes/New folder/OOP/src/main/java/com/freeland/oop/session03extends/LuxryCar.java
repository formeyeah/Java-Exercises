package com.freeland.oop.session03extends;

//Inheritance: a class is same as another class with some extra functionality 
public class LuxryCar extends Car{

	private int voltage;
	
	public LuxryCar(String type, String model, String color, int newVoltage) {
		super(type, model, color);
		voltage = newVoltage;
	}
	
	public void showVolatge() {
		System.out.println("The car is " + getClass() + " The vloatge is " + voltage);
	}
	
	public boolean canWorkwith(int cityVoltage) {
		if (cityVoltage > voltage) {
			return true;
		}else {
			return false;
		}
	}

}
