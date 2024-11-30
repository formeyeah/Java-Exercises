package com.freeland.oop.session10;

public interface ChessPiece {
	
	void moveTo(char x , char y);
	boolean validMove(char x , char y);
	String color();
	int getValue();
	
}
