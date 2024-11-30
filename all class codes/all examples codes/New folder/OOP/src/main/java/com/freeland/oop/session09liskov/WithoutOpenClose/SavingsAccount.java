package com.freeland.oop.session09liskov.WithoutOpenClose;

import java.math.BigDecimal;

public class SavingsAccount {
    protected void deposit(BigDecimal amount) {
        // Deposit into SavingsAccount
    }

    protected void withdraw(BigDecimal amount) {
        // Withdraw from SavingsAccount
    }
}
