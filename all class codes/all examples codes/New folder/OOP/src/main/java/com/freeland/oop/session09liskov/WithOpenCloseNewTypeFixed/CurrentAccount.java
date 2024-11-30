package com.freeland.oop.session09liskov.WithOpenCloseNewTypeFixed;

import java.math.BigDecimal;

public class CurrentAccount extends WithdrawableAccount {
    protected void deposit(BigDecimal amount) {
        // Deposit into CurrentAccount
    }

    protected void withdraw(BigDecimal amount) {
        // Withdraw from CurrentAccount
    }
}
