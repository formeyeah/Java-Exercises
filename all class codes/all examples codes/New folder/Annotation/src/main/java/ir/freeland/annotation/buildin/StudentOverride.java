package ir.freeland.annotation.buildin;

public class StudentOverride {
    private String name;
    private String age;
    
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
    
    
}
