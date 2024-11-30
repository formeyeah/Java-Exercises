package com.freeland.oop.session07interface.interface1;

//Polymorphism: different implementation of one class. poly-morph
class Motorcycle implements Vehicle {
    
    int speed;
    int gear;
     
    // to change gear
    @Override
    public void changeGear(int newGear){
         
        gear = newGear;
    }
     
    // to increase speed
    @Override
    public void speedUp(int increment){
         
        speed = speed + increment;
    }
     
    // to decrease speed
    @Override
    public void applyBrakes(int decrement){
         
        speed = speed - decrement;
    }
    
	@Override
    public void printStates() {
        System.out.println("Motorcycle speed: " + speed  + " gear: " + gear);
    }
     
}