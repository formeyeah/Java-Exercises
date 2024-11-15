package day2.problem0;

public class Account implements Comparable<Account> {
	private int balance;
	private String name;
	private String branch;
	private int branchNumber;
	public Account(int balance, String name, String branch) {
		super();
		this.balance = balance;
		this.name = name;
		this.branch = branch;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", name=" + name + ", branch=" + branch + ", branchNumber="
				+ branchNumber + "]";
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getBranchNumber() {
		return branchNumber;
	}
	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}
	@Override
	public int compareTo(Account o) {
		//A negative value if this.balance is less than other.balance.
		//Zero if both balances are equal.
		//A positive value if this.balance is greater than other.balance
		return this.balance-o.getBalance();
	}
	

}
