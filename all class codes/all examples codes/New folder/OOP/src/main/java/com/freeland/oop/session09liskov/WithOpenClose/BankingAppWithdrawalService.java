package com.freeland.oop.session09liskov.WithOpenClose;

import java.math.BigDecimal;

//BankingAppWithdrawalService is open for the extension with new account types, but closed for modification, 
//in that the new types don’t require it to change in order to integrate
public class BankingAppWithdrawalService {
    private Account account;

    public BankingAppWithdrawalService(Account account) {
        this.account = account;
    }

    public void withdraw(BigDecimal amount) {
        account.withdraw(amount);
    }
}
