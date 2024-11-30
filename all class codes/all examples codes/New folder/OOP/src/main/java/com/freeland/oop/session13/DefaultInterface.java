package com.freeland.oop.session13;

//Main class to test the interface and its implementations
public class DefaultInterface {
 public static void main(String[] args) {
     Animal dog = new Dog();
     dog.makeSound(); // Output: Bark
     dog.eat();       // Output: This animal eats food. (default implementation)
     dog.sleep();     // Output: This animal sleeps. (default implementation)

     Animal cat = new Cat();
     cat.makeSound(); // Output: Meow
     cat.eat();       // Output: This cat eats fish. (overridden implementation)
     cat.sleep();     // Output: This animal sleeps. (default implementation)
 }
}