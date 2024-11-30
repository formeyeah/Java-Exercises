package com.freeland.oop.session04emptyconstructor;

import java.time.LocalDateTime;

class BankAcount  {
	
    String name;
    LocalDateTime opened;
    double balance;


    public BankAcount(String name, LocalDateTime opened, double balance) {
        this.name = name;
        this.opened = opened;
        this.balance = balance;
    }

    public BankAcount(String name) {
        this(name, LocalDateTime.now(), 0.0f);
    }
    
    public BankAcount(String name, double balance) {
        this(name, LocalDateTime.now(), balance);
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
