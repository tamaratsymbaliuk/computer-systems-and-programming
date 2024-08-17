package BankSystemHW;

public interface AccountOperations {

    void deposit(double amount)throws NegativeAmountException;
    void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException;
    void changePin(String oldPin, String newPin) throws InvalidPinException;

}
