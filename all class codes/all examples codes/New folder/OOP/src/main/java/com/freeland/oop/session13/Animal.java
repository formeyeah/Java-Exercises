package com.freeland.oop.session13;

public interface Animal {
    // Abstract method
    void makeSound();

    // Default method 1
    default void eat() {
        System.out.println("This animal eats food.");
    }

    // Default method 2
    default void sleep() {
        System.out.println("This animal sleeps.");
    }
}
