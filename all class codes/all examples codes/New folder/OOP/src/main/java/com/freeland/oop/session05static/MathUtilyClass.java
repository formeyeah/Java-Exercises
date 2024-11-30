package com.freeland.oop.session05static;

/**
 * static methods
 */
public class MathUtilyClass {

	public static String[] FIBONACCI = { "0", "1", "1" , "2" , "3" };

	public static int findUnsignedNumber(int i) {
		if ( i > 0 ) {
			return i;
		}else {
			return -i;
		}
	}
	public static String[] printFibunachiNumbers() {
		String[] cars = { "bmw", "ferarry", "sandro" };
		return cars;
	}
	//hide the constructor
	private MathUtilyClass() {
		
	}
}
