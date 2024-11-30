package com.freeland.oop.session03extends;


public class Staff extends Person {
	private String idNumber;
	
	public Staff(String name ,String idNumber) {
		super(name);
		this.idNumber = idNumber;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printMyName() {
			System.out.println(" My name" + idNumber );
	}
}
