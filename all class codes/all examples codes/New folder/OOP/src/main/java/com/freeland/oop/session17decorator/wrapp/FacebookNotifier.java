package com.freeland.oop.session17decorator.wrapp;

public class FacebookNotifier implements Noditfer{
	private String faceaccount;
	public FacebookNotifier(String faceaccount) {
		this.faceaccount = faceaccount;
	}
	public void sendMeeage() {
		System.out.println("A notification to face account: " + faceaccount);
	}
}
