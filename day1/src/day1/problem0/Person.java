package day1.problem0;

public abstract class Person {
	public Person(String name, boolean sleep) {
		super();
		this.setName(name);
		this.sleep = sleep;
	}
	public Person(String name) {
		super();
		this.setName(name);
		
	}
	private String name;
	private boolean sleep=true;
	
	public abstract void Notiify();
	public  void awake() {
		if (sleep==true) {
			System.out.println(getName() +" wake up!");
		}
			
			
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	}
	

	
