package com.freeland.oop.session04emptyconstructor;

import java.time.LocalDateTime;

class BankAccount  {
    String name;
    LocalDateTime opened;
    double balance;


    public BankAccount(String name, LocalDateTime opened, double balance) {
        this.name = name;
        this.opened = opened;
        this.balance = balance;
    }

    
    public String getName() {
        return name;
    }

    public LocalDateTime getOpened() {
        return opened;
    }

    public double getBalance() {
        return this.balance;
    }
}
