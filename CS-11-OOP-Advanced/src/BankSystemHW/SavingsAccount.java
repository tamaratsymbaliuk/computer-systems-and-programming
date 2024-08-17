package BankSystemHW;

public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        try {
            deposit(interest);
            System.out.println("Interest applied: " + interest + ". New balance: " + getBalance());
        } catch (NegativeAmountException e) {
            System.out.println("Error applying interest: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount(" + getAccountNumber() + ", Balance: " + getBalance() + ", InterestRate: " + interestRate + "%)";
    }
}
