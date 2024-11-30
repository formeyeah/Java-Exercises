package com.freeland.oop.session08instanceof;

//Using instanceof
public class MainPerson {
	
	public static void main(String[] args) {
		Waitress mary = new Waitress("Mary", "mary@domain.com", 22);
		Actress susan = new Actress("Susan", "susan@domain.com", 30);
		
		if( mary instanceof Waitress) { //read:  mary is waitress
			System.out.println("mary is waitress");
		}
		if( mary instanceof Person) { //read: mary is waitress
			System.out.println("mary is person");
		}

		Class actressClass = Actress.class;
		if ( actressClass.isInstance(actressClass)) {
			System.out.println("susan is actress");
		}
	}
}
