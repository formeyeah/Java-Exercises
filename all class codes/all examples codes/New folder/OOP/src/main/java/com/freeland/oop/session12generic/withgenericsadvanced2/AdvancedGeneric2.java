package com.freeland.oop.session12generic.withgenericsadvanced2;

//Main.java
public class AdvancedGeneric2 {
 public static void main(String[] args) {
     // Create an array of Circle objects
     Circle[] circles = {
         new Circle(1.0),
         new Circle(2.0),
         new Circle(3.0)
     };

     // Create an array of Rectangle objects
     Rectangle[] rectangles = {
         new Rectangle(2.0, 3.0),
         new Rectangle(4.0, 5.0)
     };

     // Calculate total area of circles
     double totalCircleArea = ShapeUtils.calculateTotalArea(circles);
     System.out.println("Total area of circles: " + totalCircleArea);

     // Calculate total area of rectangles
     double totalRectangleArea = ShapeUtils.calculateTotalArea(rectangles);
     System.out.println("Total area of rectangles: " + totalRectangleArea);
 }
}