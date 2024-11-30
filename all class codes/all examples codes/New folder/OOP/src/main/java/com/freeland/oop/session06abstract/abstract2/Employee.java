package com.freeland.oop.session06abstract.abstract2;

public abstract class Employee {
	private String name;
	private String address;
	private int salary;

	public abstract double computePay();

	public Employee(String name, String address) {
		System.out.println("Constructing an Employee");
		this.name = name;
		this.address = address;
	}

	public void sendPaymentSms() {
		System.out.println("Dear " + this.name + " you payed: " +  computePay());
	}

	public String toString() {
		return name + " " + address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int newSalary) {
		salary = newSalary;
	}

}
