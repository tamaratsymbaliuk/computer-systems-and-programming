package BankSystemHW;

public class CheckingAccount extends Account{
    private double overdraftLimit;
    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            super.withdraw(amount); //the super keyword is used to call the withdraw method from the superclass Account. This is necessary because the CheckingAccount class extends the Account class and overrides the withdraw method to add additional behavior (checking the overdraft limit).
        } else {
            throw new InsufficientFundsException("Insufficient balance or overdraft limit exceeded.");
        }
    }
    @Override
    public String toString() {
        return "CheckingAccount(" + getAccountNumber() + ", Balance: " + getBalance() + ", OverdraftLimit: " + overdraftLimit + ")";
    }

}
