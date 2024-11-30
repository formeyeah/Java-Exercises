package com.freeland.oop.session12generic.withgenericsadvanced1;

public class GenericsAdvanced1 {
    public static void main(String[] args) {
        // Creating a Pair of Integer and String
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        System.out.println("Pair 1: Key = " + pair1.getKey() + ", Value = " + pair1.getValue());

        // Creating a Pair of String and Double
        Pair<String, Double> pair2 = new Pair<>("Pi", 3.14);
        System.out.println("Pair 2: Key = " + pair2.getKey() + ", Value = " + pair2.getValue());

        // Modifying the value of the first pair
        pair1.setValue("Updated One");
        System.out.println("Updated Pair 1: Key = " + pair1.getKey() + ", Value = " + pair1.getValue());
    }
}