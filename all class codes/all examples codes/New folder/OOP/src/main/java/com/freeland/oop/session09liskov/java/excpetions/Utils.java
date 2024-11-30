package com.freeland.oop.session09liskov.java.excpetions;

import java.io.IOException;

public abstract class Utils {
	
    public abstract void readFile() throws IOException;        
    public abstract void writeFile() throws IOException;
    public abstract void calculate() throws NumberFormatException,IllegalAccessError;
    // Other Methods
}
