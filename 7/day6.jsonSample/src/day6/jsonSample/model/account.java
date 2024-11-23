package day6.jsonSample.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class account {
	@Override
	public String toString() {
		return "account [name=" + name + ", balance=" + balance + ", transaction=" + transaction + "]";
	}
	private String name;
	@JsonProperty("balances")
	private int balance;
	private Transaction transaction;
	public account() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public account(String name, int balance, Transaction transaction) {
		super();
		this.name = name;
		this.balance = balance;
		this.transaction = transaction;
	}

	

}
