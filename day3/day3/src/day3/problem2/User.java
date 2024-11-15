package day3.problem2;
/*
   ye object darim tahte onvane User, ke ye list az string e account dare,  yek username darad, yek string password darad, 
   string cardNumber dare, setter getter, 
   new konid du seta user , yebar serialize konid yebar deserialize konid

cardNumber va password ro persist nakonid, serialize nakonid 

file haye serialize shodasham baz kon ke password va cardNumber tosh nabashe
 */

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	@Override
	public String toString() {
		return "User [account=" + account + ", username=" + username + "]";
	}
	public User(List<String> account, String username, String password, String cardNumber) {
		super();
		this.account = account;
		this.username = username;
		this.password = password;
		this.cardNumber = cardNumber;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> account;
	private String username;
	private transient String password;
	private transient String cardNumber;
	public List<String> getAccount() {
		return account;
	}
	public void setAccount(List<String> account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	

}
