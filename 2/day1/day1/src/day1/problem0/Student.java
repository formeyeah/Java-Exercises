package day1.problem0;

public class Student extends Person {
	public Student(String name, String studentNumber) {
		super(name);
		this.studentNumber = studentNumber;
	}

	private String studentNumber;


	@Override
	public void Notiify() {
		System.out.println("Dear"+ getName() +"ma notify et kardim ba sms");
		

	}

}
