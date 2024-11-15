package day1.problem1;

public class Circle implements Shape{
	public Circle(double radio) {
		super();
		this.radio = radio;
	}

	private double radio;
	
	
	@Override
	public double area() {
		
		return radio*radio*3.14;
		
	}

}
