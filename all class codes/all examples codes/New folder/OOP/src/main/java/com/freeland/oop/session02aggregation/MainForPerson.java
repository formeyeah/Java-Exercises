package com.freeland.oop.session02aggregation;

/**
 * object association and relations
 */
public class MainForPerson {

	public static void main(String[] args) {
		
		//This is called Aggregation 
		Person staff = new Person(); //Describe the default constructor
		staff.setName("Alireza");
		staff.setAge(48);
		
		//The Person and Address objects are different but Person with no Address is somehow useless.
		Address staffAddress = new Address();
		staffAddress.setCountry("Iran");
		staffAddress.setCity("Tehran");
		staffAddress.setLocation("41°24'12.2N 2°10'26.5E.");
		staff.setAddress(staffAddress);

		//Person and Car are different. Means the life cycles of the objects aren’t tied.
		Car golf = new Car("Volkswagen", "Golf", "green");
		staff.setCar(golf);
		
	}

}
