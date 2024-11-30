package com.freeland.oop.session17decorator.wrapp;

import java.util.List;

//Decorator is a structural design pattern that lets you attach new behaviors to objects 
//by placing these objects inside special wrapper objects that contain the behaviors.

public class UseNotificationMain {

	public static void main(String[] args) {
		
		//Ordinary use
		SMSNotifier sms = new SMSNotifier("09123046913");
		sms.sendMeeage();
		
		FacebookNotifier facebook = new FacebookNotifier("afattahi");
		facebook.sendMeeage();
		
		EmailNotifier email = new EmailNotifier("afattahi54@gmail.com");
		email.sendMeeage();
		
		//With a decorator
		BaseNotifer base = new BaseNotifer( List.of(facebook,email,sms));
		base.sendMeeage();
	}

}
