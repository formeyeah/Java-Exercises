package com.freeland.oop.session06abstract.abstract2;

public class MainEmployee {

	public static void main(String[] args) {

		Manager jhon = new Manager("Johon Nash", "Chigago");
		jhon.setSalary(100);
		TopManager paul = new TopManager("Paul Bill", "Newyork");
		paul.setSalary(100);
		jhon.sendPaymentSms();
		paul.sendPaymentSms();
	}

}
