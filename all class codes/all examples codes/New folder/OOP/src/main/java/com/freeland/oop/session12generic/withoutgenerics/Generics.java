package com.freeland.oop.session12generic.withoutgenerics;

public class Generics {
	public static void main(String[] args) {
		
		Box box = new Box("Alreza");
		String name = (String) box.getItem();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        // Creating a Box for Integer
        Box integerBox = new Box(123);
        System.out.println("Integer Box contains: " + integerBox.getItem());

        // Creating a Box for String
        Box stringBox = new Box("Hello Generics");
        System.out.println("String Box contains: " + stringBox.getItem());         

        // Creating a Box for Double
        Box doubleBox = new Box(45.67);
        System.out.println("Double Box contains: " + doubleBox.getItem());

        // Changing the item in the string box
        stringBox.setItem("Updated String");
        System.out.println("Updated String Box contains: " + stringBox.getItem());
        
        String theStringInTheBox = (String)stringBox.getItem(); //Casting. The box holds objects 
    }
}
