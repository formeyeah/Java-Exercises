package com.freeland.oop.session06abstract.abstract2;

public class Manager extends Employee {
	public Manager(String name, String address) {
		super(name, address);
	}

	public double computePay() {
		return getSalary() * 1.2;
	}
}
