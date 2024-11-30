package com.freeland.oop.session09liskov.WithOpenCloseNewTypeFixed;

import java.math.BigDecimal;

public class SavingsAccount extends WithdrawableAccount {
    protected void deposit(BigDecimal amount) {
        // Deposit into SavingsAccount
    }

    protected void withdraw(BigDecimal amount) {
        // Withdraw from SavingsAccount
    }
}
