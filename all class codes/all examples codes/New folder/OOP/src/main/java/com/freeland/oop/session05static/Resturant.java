package com.freeland.oop.session05static;

/**
 * use static for save state
 */
public class Resturant {

	private static int soldPizza;
	private static int soldSandewitch;


	public void sellPizza() {
		soldPizza++;
	}
	public void sellSandewitch() {
		soldSandewitch++;
	}
	
    public static void main(String[] a) {
    	Resturant starburger = new Resturant();
    	starburger.sellPizza();
    	starburger.sellPizza();
    	starburger.sellPizza();
    	starburger.sellSandewitch();
    	
    	System.out.println( Resturant.soldPizza );
    	System.out.println( Resturant.soldSandewitch );
    	
    	Resturant sana = new Resturant();
    	sana.sellPizza();
    	sana.sellPizza();
    	sana.sellPizza();
    	sana.sellSandewitch();
    	System.out.println( Resturant.soldPizza );
    	System.out.println( Resturant.soldSandewitch );
    }

}
