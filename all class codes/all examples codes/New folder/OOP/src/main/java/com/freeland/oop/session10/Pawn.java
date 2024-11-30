package com.freeland.oop.session10;

public class Pawn implements ChessPiece { //Read Pawn IS-A ChessPiece

	@Override
	public void moveTo(char x, char y) {
		System.out.println("Pawn will move to " + x + y);

	}

	@Override
	public boolean validMove(char x, char y) {
		return false;
	}

	@Override
	public String color() {
		return null;
	}

	@Override
	public int getValue() {
		return 0;
	}

}
