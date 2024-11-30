package com.freeland.oop.session09liskov.java.excpetions;

import java.io.EOFException;

public class AdvancedUtils extends Utils {

	//Narrow excpetion. IF some one can handle IOExcpetion it can handle its subtype EOFException
	@Override
	public void writeFile() throws EOFException {
	}

	//when the client code substitutes a subtype, it can handle the method throwing 
	//fewer exceptions than the supertype method. 
	@Override
	public void calculate() throws NumberFormatException {
		
	}
	//when the client code substitutes a subtype, it can handle no exception situation 
	@Override
	public void readFile() {
	}



	
    

}