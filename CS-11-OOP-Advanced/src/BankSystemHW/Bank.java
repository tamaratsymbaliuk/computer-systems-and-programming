package BankSystemHW;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers;

    public Bank() {
        this.customers = new HashMap<>();
    }
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        System.out.println("Customer " + customer + " added to the bank.");
    }
    public Customer getCustomerById(String customerId) {
        return customers.get(customerId);
    }
    public void removeCustomer(String customerId) {
        customers.remove(customerId);
        System.out.println("Customer with ID " + customerId + " removed from the bank.");
    }


}
