package com.freeland.oop.session10;

public class MainChess {

	public static void main(String[] args) {
		Pawn p1 = new Pawn();
		Queen queen = new Queen();
		
		p1.moveTo('a', '2');
		queen.moveTo('c', '5');
		

		ChessPiece p3 = new Pawn();
		p3.moveTo('a', '3'); //dynamic binding (Open implementation menu)
	}

}
