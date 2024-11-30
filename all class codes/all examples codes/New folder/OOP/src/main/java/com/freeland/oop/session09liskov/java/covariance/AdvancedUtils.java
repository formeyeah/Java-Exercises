package com.freeland.oop.session09liskov.java.covariance;

import java.io.LineNumberReader;

public class AdvancedUtils extends Utils {
    
	 @Override
    public Integer generateNumber() {
        return Integer.valueOf(10);
    }
	 
	@Override
    public LineNumberReader readFile() {
    	return null;
    }
    // Other Methods
}