package com.freeland.oop.session10;

public class Queen implements ChessPiece { //Read Queen IS-A ChessPiece

	@Override
	public void moveTo(char x, char y) {
		System.out.println("Queen will move to " + x + y);

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
