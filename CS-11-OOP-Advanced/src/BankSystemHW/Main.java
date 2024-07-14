package BankSystemHW;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Tomas Smith", "id78484");

        SavingsAccount savingsAccount = new SavingsAccount("1234", 100.00, 3.00);
        CheckingAccount checkingAccount = new CheckingAccount("5678", 1000.00, 10);

        customer.addAccount(savingsAccount);
        customer.addAccount(checkingAccount);
        // Perform operations
        savingsAccount.deposit(500);
        savingsAccount.applyInterest();

        checkingAccount.withdraw(600);
        checkingAccount.withdraw(500);  // Exceeds overdraft limit

        // Display customer and accounts
        System.out.println(customer);
        System.out.println(savingsAccount);
        System.out.println(checkingAccount);
    }
}
