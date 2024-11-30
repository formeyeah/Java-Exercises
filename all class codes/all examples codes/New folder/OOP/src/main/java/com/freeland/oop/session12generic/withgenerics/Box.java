package com.freeland.oop.session12generic.withgenerics;

//This is Generic CLASS
public class Box<T> { //T means type. It can be any thing X,Q,TYPE

	private T item;
	
	public Box(T item) { //Generic can be used in method signature
	   this.item = item;
	}
	
	public T getItem() { //Generic can be used in return type
	   return item;
	}
	
	// Method to set a new item in the box
	public void setItem(T item) {
	   this.item = item;
	}
}