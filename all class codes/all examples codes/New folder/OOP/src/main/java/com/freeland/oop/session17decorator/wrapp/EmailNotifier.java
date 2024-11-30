package com.freeland.oop.session17decorator.wrapp;

public class EmailNotifier implements Noditfer{
	private String email;
	public EmailNotifier(String email) {
		this.email = email;
	}
	public void sendMeeage() {
		System.out.println("A notification to email: " + email);
	}
}
