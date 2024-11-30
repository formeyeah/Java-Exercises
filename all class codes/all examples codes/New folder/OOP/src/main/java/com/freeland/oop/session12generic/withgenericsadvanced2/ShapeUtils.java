package com.freeland.oop.session12generic.withgenericsadvanced2;

//ShapeUtils.java
public class ShapeUtils {
 // Generic method with upper bound
 //Look this is generic METHOD. It shows the type of the parameter
	
 public static <T extends Shape> double calculateTotalArea(T[] shapes) {
	     double totalArea = 0;
	     for (T shape : shapes) {
	         totalArea += shape.area();
	     }
	     return totalArea;
 	}
 

//  For above example genetics is not a must, we can rewrite it with interface
// 	public  double calculateTotalArea2 (Shape[] shapes) {
//	     double totalArea = 0;
//	     for (Shape shape : shapes) {
//	    	 totalArea += shape.area();
//		}
//
//	     return totalArea;
//	}
// 	
//   But for somthing like this generics are much simpler
// 	 public static <T, S extends T> void copy(List<T> dest, List<S> src) {

}

