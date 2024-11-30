package com.freeland.oop.session17builder;
public class House {
    private int area;
    private String location;
    private String name;
    private String postalCode;

    // Private constructor to enforce the use of the Builder
    private House(Builder builder) {
        this.area = builder.area;
        this.location = builder.location;
        this.name = builder.name;
        this.postalCode = builder.postalCode;
    }

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

    // Static nested Builder class
    public static class Builder {
        private int area;
        private String location;
        private String name;
        private String postalCode;

        public Builder area(int area) {
            this.area = area;
            return this; // Return the Builder for chaining
        }

        public Builder location(String location) {
            this.location = location;
            return this; // Return the Builder for chaining
        }

        public Builder name(String name) {
            this.name = name;
            return this; // Return the Builder for chaining
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this; // Return the Builder for chaining
        }

        public House build() {
            // Validate location
            if (location == null || location.trim().isEmpty()) {
                throw new IllegalArgumentException("Location cannot be empty.");
            }
            return new House(this);
        }
    }
}