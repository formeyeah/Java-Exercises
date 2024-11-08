package day1.problem1;

public class MainForProblem1 {

	public static void main(String[] args) {
		Circle[] circles= {
			new Circle(5.0),
			new Circle (1.0)
		};
		
		Rectangle[] rectangles={
			new Rectangle(1.0,2.0)
		};
		
		Square[] squares= {
				
				new Square(2.0),
				new Square(4.0)
		};
		
		double totalCircles=Shapecalculator.CalculateArea(circles);
		System.out.println("total area of squares " + totalCircles);
		
		
		double totalRectangles=Shapecalculator.CalculateArea(rectangles);
		System.out.println("totol area of rectangles: " + totalRectangles);
		
		
		double totalSquares=Shapecalculator.CalculateArea(squares);
		System.out.println("totol area of Squares: " + totalSquares);
		

	}

}
