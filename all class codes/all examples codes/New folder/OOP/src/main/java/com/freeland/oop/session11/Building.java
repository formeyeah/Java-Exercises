package com.freeland.oop.session11;

//Talk about Composition (Has-A life dependence)
public class Building {

	public String address;
	public Room room; // Read HAS-A room

	Room createRoom(String color) {
		return room = new Room(color);
	}

	// This is inner-class
	// the objects’ lifecycles are tied. It means that if we destroy the owner
	// object, its members also will be destroyed with it

	public class Room {
		public String color;
		public Room(String color) {
			this.color = color;
		}
		public boolean isReady() {
			return true;
		}
	}

}
