package com.freeland.oop.session08instanceof;

public class Actress extends Person {
    
    public Actress(String name, String email, int age) {
        super(name, email, age);
    }
    
    public String readScript(String movie) {
        return "Reading the script of " + movie;
    }
    
    public String performRole() {
        return "Performing a role";
    }
}
