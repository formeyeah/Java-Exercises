package com.freeland.oop.session04emptyconstructor;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Design concern:
 * Empty constructor for initialization
 */
public class MainForBankAccount {

	public static void main(String[] args) {
		LocalDateTime opened = LocalDateTime.of(2018, Month.JUNE, 29, 06, 30, 00);
		BankAccount myAccount = new BankAccount("Jone", opened, 12.0);
		
		BankAccount2 account = new BankAccount2();
		
		//BankAccount bankAccount = new  BankAccountEmptyConstructor();
		BankAcount account1 = new BankAcount("Bob");
		BankAcount account2 = new BankAcount("Bob",130.0);
		BankAcount account3 = new BankAcount("Bob",opened,130.0);
	}

}
