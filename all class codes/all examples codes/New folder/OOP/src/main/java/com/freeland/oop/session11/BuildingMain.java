package com.freeland.oop.session11;

import com.freeland.oop.session11.Building.Room;

public class BuildingMain {
	public static void main(String[] args) {
		Building hospital = new Building();
		hospital.address="Tajrish Sq.";
		Room surgeryRoom = hospital.createRoom("red");
		surgeryRoom.isReady();//Set breakpoint see $ in inner-class see this$0 and building

	}
}
