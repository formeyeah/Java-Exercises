package com.freeland.oop.session07interface.interface2multi;

//Class that implements both Animal and Pet interfaces
class Dog implements Animal, Pet {
	 @Override
	 public void eat() {
	     System.out.println("The dog is eating.");
	 }
	
	 @Override
	 public void play() {
	     System.out.println("The dog is playing.");
	 }
}