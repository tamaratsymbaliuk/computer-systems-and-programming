package BankSystemHW;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers;

    public Bank() {
        this.customers = new HashMap<>();
    }
}
