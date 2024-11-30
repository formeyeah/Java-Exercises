package com.freeland.oop.session17decorator.wrapp;

import java.util.List;

public class BaseNotifer implements Noditfer {
	List<Noditfer> notifiers;
	
	public BaseNotifer(List<Noditfer> notifiers) {
		this.notifiers = notifiers;
		
	}

	@Override
	public void sendMeeage() {
		for (Noditfer aNotifier : notifiers) {
			aNotifier.notify();
		}

	}

}
