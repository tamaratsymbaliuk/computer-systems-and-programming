public class TryCatchThrowNewExample {
    double balance;

    public void processWithdrawal(double amount) {
        try {
            withdraw(amount);  // This might throw an InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");  // Throw an exception
        }
        balance -= amount;
    }

}
