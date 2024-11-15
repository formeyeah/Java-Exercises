package day1.problem1;

public class Square implements Shape {
	private double a; 
	public Square(double a) {
		super();
		this.a=a;
		
		
		
	}

	
	@Override
	public double area() {
		return a*a; 
	}

}
