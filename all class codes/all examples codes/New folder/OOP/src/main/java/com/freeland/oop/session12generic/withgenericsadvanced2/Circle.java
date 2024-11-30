package com.freeland.oop.session12generic.withgenericsadvanced2;

//Circle.java
public class Circle extends Shape {
 private double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 @Override
 public double area() {
     return Math.PI * radius * radius; // Area of a circle: πr²
 }
}