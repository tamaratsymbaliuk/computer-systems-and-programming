package BankSystemHW;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer implements CustomerOperations {
    private String name;
    private String customerId;
    private List<Account> accounts;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>(); // initializes the accounts
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account + " added to customer " + name + ".");
    }

    @Override
    public void removeAccount(Account account) {
        accounts.remove(account);
        System.out.println("Account " + account + " removed from customer " + name + ".");
    }

    public void viewAccounts() {
        for (Account account: accounts) {
            System.out.println("List of accounts: " + account);
        }

    }
    public void performDeposit(Account account, double amount) {
        try {
            account.deposit(amount);
        } catch (NegativeAmountException e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    public void performWithdrawal(Account acccount, double amount) {
        try {
            acccount.withdraw(amount);
        } catch (InsufficientFundsException | NegativeAmountException e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }
    }
    public void sortAccountByBalance() {
        accounts.sort(Comparator.comparingDouble(Account::getBalance));
        System.out.println("Accounts sorted by balance:");
        viewAccounts();
    }
    public void sortAccountsByType() {
        accounts.sort(Comparator.comparing(Account::getAccountType));
        System.out.println("Accounts sorted by type:");
        viewAccounts();
    }



    public String toString() {
        return "Customer(" + name + ", ID: " + customerId + ")";
    }
    }

