package com.freeland.oop.session09liskov.WithOpenCloseNewType;

import java.math.BigDecimal;

//BankingAppWithdrawalService is open for the extension with new account types, but closed for modification, 
//in that the new types don’t require it to change in order to integrate

//IT is Open: Add new Account is easy, you do not need to change this service 
//IT is Closed: Change any account type but this service will still works
public class BankingAppWithdrawalService {
    private Account account;

    public BankingAppWithdrawalService(Account account) {
        this.account = account;
    }

    public void withdraw(BigDecimal amount) {
        account.withdraw(amount);
    }
}
