package day7.problem1.prettyPrintExample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	public Person() {
		super();
	}
	@JsonProperty("name")
	private String name;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("account")
	private Account account;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public Person(String name, String lastName, Account account) {
		this.name=name;
		this.lastName=lastName;
		this.account=account;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", account=" + account + "]";
	}
	
}
