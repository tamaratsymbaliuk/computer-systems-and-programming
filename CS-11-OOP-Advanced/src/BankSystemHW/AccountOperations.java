package BankSystemHW;

public interface AccountOperations {

    void deposit(double amount);
    void withdraw(double amount);
    void changePin(String oldPin, String newPin);

}
