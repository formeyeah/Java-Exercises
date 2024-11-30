package com.freeland.oop.session17builder;

public class HouseWithConstructor {
    private int area;
    private String location;
    private String name;
    private String postalCode;

    // Constructor with all properties
    public HouseWithConstructor(int area, String location, String name, String postalCode) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty.");
        }
        this.area = area;
        this.location = location;
        this.name = name;
        this.postalCode = postalCode;
    }

    // Getters
    public int getArea() {
        return area;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }
}