package day1.problem1;

public class Rectangle implements Shape{
	private double a; 
	private double b;
	public Rectangle(double a, double b) {
		super();
		this.a=a;
		this.b=b;
		
		
		
	}
	@Override 
	public double area() {
		return a*b;
		
	}

}
