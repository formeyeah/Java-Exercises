package com.freeland.oop.session13;

//Implementing class Dog
public class Dog implements Animal {
 @Override
 public void makeSound() {
     System.out.println("Bark");
 }

 // Dog can use the default eat() and sleep() methods or override them
}