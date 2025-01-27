package com.scaler;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private double balance;
    private String accountHolderName;
    private ArrayList<String> transactionHistory = new ArrayList<String>();

    public BankAccount(){

        balance = 52000;
        accountHolderName = "Faiaz";
    }

    public BankAccount(double newBalance, String newAccountHolder){

        balance = newBalance;
        accountHolderName = newAccountHolder;
    }

    public void setBalance(double newBalance){

        if(accountHolderName == "Faiaz"){

            balance += newBalance;
        }
        else{

            throw new RuntimeException("Unauthorized Credential");
        }
    }

    public double getBalance(){

        if(accountHolderName == "Faiaz"){

            return balance;
        }
        else{

            throw new RuntimeException("Unauthorized Credential");
        }
    }

    public void setAccountHolderName(String newAccountHolderName){

        accountHolderName = newAccountHolderName;
    }

    public String getAccountHolderName(){

        return accountHolderName;
    }

    public void deposit(double amount) {

        if(amount < 0){

            System.out.println("Invalid amount");
        }

        balance = balance + amount;

        System.out.println("Transaction Completed");
        transactionHistory.add(amount + " Credited");
    }

    public void withdraw(double amount){

        if(balance < amount || balance == 0){

            System.out.println("Insufficient Balance");
        }
        else{

            double updatedBalance = balance - amount;

            balance = updatedBalance;
            transactionHistory.add(amount + " Debited");
        }

        System.out.println("Transaction completed");
        System.out.println("Available Balance :" + balance);

        public void printTransactionHistory(){

            for(String transaction : transactionHistory){

                System.out.println(transaction);
            }
        }
    }
}
