package com.freeland.oop.session04emptyconstructor;

import java.time.LocalDateTime;

class BankAccount2  {
	
    String name;
    LocalDateTime opened;
    double balance;

    public BankAccount2() {
        this.name = "";
        this.opened = LocalDateTime.now();
        this.balance = 0.0d;
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
