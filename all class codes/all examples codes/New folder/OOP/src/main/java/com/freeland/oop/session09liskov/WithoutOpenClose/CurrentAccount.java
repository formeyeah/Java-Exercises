package com.freeland.oop.session09liskov.WithoutOpenClose;

import java.math.BigDecimal;

public class CurrentAccount {
    protected void deposit(BigDecimal amount) {
        // Deposit into CurrentAccount
    }

    protected void withdraw(BigDecimal amount) {
        // Withdraw from CurrentAccount
    }
}
