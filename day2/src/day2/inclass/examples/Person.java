package day2.inclass.examples;

public class Person implements Comparable<Person> {
	private String name;
	private String email;
	private int age;
	public Person(String name, String email, int age) {
		this.name=name;
		this.email=email;
		this.age=age;
	}
	public String getName() {
		return this.name;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	@Override
	public String toString() {
		return "name: " + name;
	}
	@Override
	public int compareTo(Person o) {
		
		return o.getAge()-this.age;
	}
}
