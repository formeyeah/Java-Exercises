package com.freeland.oop.session02aggregation;

//Show code generation
public class Person {
	private String name;
	private int age;

	private Address address; // A Person without address is valid but not complete (Has-A aggregation)
	private Car car; 		 // A Person without car is quite OK ( The person and car are association )

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

}
