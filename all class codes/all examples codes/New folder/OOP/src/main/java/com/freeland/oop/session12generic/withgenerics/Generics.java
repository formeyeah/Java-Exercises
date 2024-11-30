package com.freeland.oop.session12generic.withgenerics;

public class Generics {
	public static void main(String[] args) {
        // Creating a Box for Integer
        Box<Integer> integerBox = new Box<>(123);
        System.out.println("Integer Box contains: " + integerBox.getItem());

        // Creating a Box for String
        Box<String> stringBox = new Box<>("Hello Generics");
        System.out.println("String Box contains: " + stringBox.getItem());

        // Creating a Box for Double
        Box<Double> doubleBox = new Box<>(45.67);
        System.out.println("Double Box contains: " + doubleBox.getItem());

        // Changing the item in the string box
        stringBox.setItem("Updated String");
        System.out.println("Updated String Box contains: " + stringBox.getItem());
        
    }
}
