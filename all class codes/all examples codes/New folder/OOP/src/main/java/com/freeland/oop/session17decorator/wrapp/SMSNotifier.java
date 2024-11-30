package com.freeland.oop.session17decorator.wrapp;

public class SMSNotifier implements Noditfer{
	private String phonNumber;
	public SMSNotifier(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	public void sendMeeage() {
		System.out.println("A notification to phon number: " + phonNumber);
	}
}
