package com.freeland.oop.session09liskov.WithoutOpenClose;

import java.math.BigDecimal;

//The BankingAppWithdrawalService is aware of the two concrete implementations of account. 
//Therefore, the BankingAppWithdrawalService would need to be changed every time a new account type is 
//introduced.

public class BankingAppWithdrawalService {
    private SavingsAccount savingsAccount = new SavingsAccount();
    private CurrentAccount currentAccount = new CurrentAccount();


    public void withdrawSavingsAccount(BigDecimal amount) {
    	savingsAccount.withdraw(amount);
    }
    
    public void withdrawCurrentAccount(BigDecimal amount) {
    	currentAccount.withdraw(amount);
    }
    
    public void depositSavingsAccount(BigDecimal amount) {
    	savingsAccount.deposit(amount);
    }
    
    public void depositCurrentAccount(BigDecimal amount) {
    	currentAccount.deposit(amount);
    }
}
