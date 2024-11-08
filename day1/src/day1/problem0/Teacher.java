package day1.problem0;

public class Teacher extends Person {
	private String teacherNumber;
	public Teacher(String name, String teacherNumber) {
		super(name);
		this.teacherNumber=teacherNumber;
	}
	public void Notiify() {
		System.out.println("Dear"+ getName() +"ma notify et kardim ba call");
		
		
	}
}
