package BankSystemHW;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Tomas Smith", "id78484");

        SavingsAccount savingsAccount = new SavingsAccount("1234", 100.00, 3.00);
        CheckingAccount checkingAccount = new CheckingAccount("5678", 1000.00, 10);

        customer.addAccount(savingsAccount);
        customer.addAccount(checkingAccount);
        try {
            // Perform operations
            savingsAccount.deposit(500);
            savingsAccount.applyInterest();

            checkingAccount.withdraw(600);
            checkingAccount.withdraw(500);  // Exceeds overdraft limit

            // Change PIN
            savingsAccount.changePin(null, "1234");  // Setting initial PIN
            savingsAccount.changePin("1234", "5678");
        } catch (NegativeAmountException | InsufficientFundsException | InvalidPinException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }


        // Display customer and accounts
        System.out.println(customer);
        customer.viewAccounts();
    }
}
