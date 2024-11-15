package day0.problem7;

public class Account {

	public Account(String branch) {
		super();
		this.branch = branch;
	}
	public Account(int balance) {
		super();
		this.balance = balance;
	}
	
	//class e shomare hesab 
	//property -> balance , branch, locked(qofl hast ya na boolean), lastTransaction
	//method-> print -> if called print every info , withdraw -> adad migire age adad bishstr az balance bshe khata age na balance ro kaheesh mide
	//yedune constructor -> fqt balance bgire 
	//yedune constructor -> fqt branch bgire 
	
	private int balance;
	private String branch;
	private boolean locked;
	private String lastTransaction;
	
	public void printInfo() {
		
		System.out.println("balance is "+ balance);
		System.out.println("branch is" + branch );
		System.out.println("locked?" + locked );
		System.out.println("lastTransaction "+ lastTransaction);
	}
	public boolean islocked() {
		if (locked) {
			return true; 
		}
		else {
			return false;
		}
	}
	
	public int withdraw(int withdraw) {
		
		if (withdraw<this.balance) {
			balance=this.balance - withdraw;
			System.out.println("withdraw successfully");
			lastTransaction="withdraw:" + withdraw;
			return balance;
		}		
		else {
			return 0;
		}
	}




}





