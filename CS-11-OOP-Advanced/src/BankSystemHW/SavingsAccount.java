package BankSystemHW;

public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest applied: " + interest + ". New balance: " + getBalance());
    }
    @Override
    public String toString() {
        return "SavingsAccount(" + getAccountNumber() + ", Balance: " + getBalance() + ", InterestRate: " + interestRate + "%)";
    }
}
