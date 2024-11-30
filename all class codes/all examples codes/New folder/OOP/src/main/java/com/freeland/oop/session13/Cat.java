package com.freeland.oop.session13;

//Implementing class Cat
public class Cat implements Animal {
 @Override
 public void makeSound() {
     System.out.println("Meow");
 }

 // Overriding the default eat() method
 @Override
 public void eat() {
     System.out.println("This cat eats fish.");
 }

 // Cat can use the default sleep() method
}

