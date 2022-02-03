package dev.benjamin.models;

import dev.benjamin.exceptions.NegativeBalanceException;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double balance;
    private String role;

    public User() {
    }

    public User(int id, String firstName, String lastName, String username, String password, double balance, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.balance = 1000;
        this.role = role;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }



    public void setBalance(double disbursement) {
        if (this.balance - disbursement > 0) {
            this.balance = this.balance - disbursement;
        } else {
            throw new NegativeBalanceException("this transaction results in a negative balance.");
        }
    }

    public void resetBalance(){
        this.balance = 1000;
    }
}


