package BankAccount;

public class BankAccount {
    private static int count = 1;
    private int id;
    private double balance;
    private static double interest = 0.02;

    public BankAccount() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public static void setInterest(double interest) {
        BankAccount.interest = interest;
    }

    public double getInterest(int years) {
        return this.balance * interest * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
