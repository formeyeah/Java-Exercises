package com.freeland.oop.session07interface.interface1;

/**
 * interface implement from scratch
 * dynamic binding vs static binding
 */
public class VehicleMain {

	public static void main(String[] args) {
		// creating an instance of Bicycle
        // doing some operations
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);
         
        System.out.println("Bicycle present state :");
        bicycle.printStates();
         
        // creating instance of the bike.
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.changeGear(1);
        motorcycle.speedUp(4);
        motorcycle.applyBrakes(3);
         
        System.out.println("Motorcycle present state :");
        motorcycle.printStates();
        
        //Dynamic Binding:
        //During compilation, the compiler has no idea as to which print has to be called since the compiler 
        //goes only by referencing variable not by the type of object, and therefore the binding would be 
        //delayed to runtime
        Vehicle vehicle = new Bicycle();
        vehicle.changeGear(1);
        vehicle.speedUp(2);
        vehicle.applyBrakes(1);
        vehicle.printStates();

	}

}
