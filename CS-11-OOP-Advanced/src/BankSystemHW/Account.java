package BankSystemHW;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements AccountOperations {

    private String accountNumber;
    private double balance;
    private String pin;
    private List<String> transactionHistory;
    private AccountType accountType;

    public Account(String accountNumber, double balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        this.accountType = accountType;
    }

    public Account(String accountNumber, double balance, String pin, AccountType accountType) {
        this(accountNumber, balance, accountType);
        this.pin = pin;
    }
    public Account(String accountNumber, AccountType accountType) {
        this(accountNumber, 0.0, accountType);
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public AccountType getAccountType() {
        return accountType;
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

