package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int balance = 0;
        for (int i = 0; i < this.charges.size(); i++) {
            int chargeToAdd = this.charges.get(i).getCharge();
            balance += chargeToAdd;
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    public void addCharge(AccountRecord c) {
        this.charges.add(c);
    }

    @Override
    public String toString() {
        return "Customer ID: " + this.id + "\nCustomer Name: " + this.name + "\nCustomer Balance: " + this.getBalance();
    }
}
