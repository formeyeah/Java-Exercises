package day6.jsonSample.model;

public class Transaction {
	private String to;
	private int amount;
	private String description;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "Transaction [to=" + to + ", amount=" + amount + ", description=" + description + "]";
	}
	public Transaction() {
		super();
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Transaction(String to, int amount, String description) {
		super();
		this.to = to;
		this.amount = amount;
		this.description = description;
	}

}
