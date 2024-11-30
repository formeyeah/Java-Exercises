package com.freeland.oop.session09liskov.WithOpenCloseNewTypeFixed;

import java.math.BigDecimal;

public class FixedTermDepositAccount extends Account {
    protected void deposit(BigDecimal amount) {
        // Deposit into this account
    }
}
