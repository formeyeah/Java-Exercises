package day1.problem0;

public class MainforProblem0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ye class e person darim ke ye name dare msln -> ye method e abstract e notify dare 
		// student -> ba sms notify 
		//teacher -> ba call notify ina class hastan har seta 
		//manager -> ba in person notify 
		// in seta method haye notify eshon frq dare
		//ye method e main benevisid inaro new konid 
		//bad ye method e awake moshtrak beyne haamahson benevisid
		
		
		//student -> name and student Number
		Student student1 = new Student("student1 ", "1");
		student1.Notiify();
		
		//Teacher -> name and teacherNumber 
		Teacher teacher1=new Teacher("teacher1 ", "1");
		teacher1.Notiify();
		teacher1.awake();
		
		
		//Manager -> name 
		Manager manager=new Manager("dear manager");
		manager.Notiify();
		manager.awake();
		
		
		
	}

}
