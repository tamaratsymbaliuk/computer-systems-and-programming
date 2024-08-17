package BankSystemHW;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements AccountOperations {

    private String accountNumber;
    private double balance;
    private String pin;
    private List<String> transactionHistory;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public Account(String accountNumber, double balance, String pin) {
        this(accountNumber, balance);
        this.pin = pin;
    }
    public Account(String accountNumber) {
        this(accountNumber, 0.0);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public boolean verifyPin(String pin) {
        return this.pin != null && this.pin.equals(pin);
    }

    @Override
    public void changePin(String oldPin, String newPin) throws InvalidPinException {
        if (verifyPin(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            throw new InvalidPinException("Incorrect old PIN.");
        }
    }

    @Override
    public void deposit(double amount) throws NegativeAmountException {
        if (amount > 0) {
            balance += amount;
            String transaction = "Deposited " + amount + ". New balance: " + balance;
            addTransaction(transaction);
            System.out.println(transaction);
        } else {
            throw new NegativeAmountException("Deposit amount must be positive.");
        }
        }

    @Override
    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new NegativeAmountException("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance.");
        } else {
            balance -= amount;
            String transaction = "Withdrew " + amount + ". New balance: " + balance;
            addTransaction(transaction);
            System.out.println(transaction);
        }
    }
    @Override
    public String toString() {
        return "Account(" + accountNumber + ", Balance: " + balance + ")";
    }
}

