package com.freeland.oop.session06abstract.abstract2;

public class TopManager extends Employee {
	public TopManager(String name, String address) {
		super(name, address);
	}

	public double computePay() {
		return getSalary() * 1.4;
	}
}
