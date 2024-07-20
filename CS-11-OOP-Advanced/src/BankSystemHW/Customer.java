package BankSystemHW;

import java.util.ArrayList;
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

    public String toString() {
        return "Customer(" + name + ", ID: " + customerId + ")";
    }
    }

