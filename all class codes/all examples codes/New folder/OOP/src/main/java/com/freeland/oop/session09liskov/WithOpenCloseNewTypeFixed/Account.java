package com.freeland.oop.session09liskov.WithOpenCloseNewTypeFixed;

import java.math.BigDecimal;

public abstract class Account {
    protected abstract void deposit(BigDecimal amount);
}
