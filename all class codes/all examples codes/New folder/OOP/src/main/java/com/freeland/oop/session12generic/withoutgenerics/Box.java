package com.freeland.oop.session12generic.withoutgenerics;

//Box.java
public class Box {
	// Attribute to hold the item
	private Object item;
	
	// Constructor to initialize the Object with an item
	public Box(Object item) {
	   this.item = item;
	}
	
	// Method to get the Object from the box
	public Object getItem() {
	   return item;
	}
	
	// Method to set a new Object in the box
	public void setItem(Object item) {
	   this.item = item;
	}
}