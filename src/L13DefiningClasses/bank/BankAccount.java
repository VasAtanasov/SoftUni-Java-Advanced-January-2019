package L13DefiningClasses.bank;

public class BankAccount {
    private static final double DEFAULT_INTEREST = 0.02;

    private static double rate;
    private static int bankAccountCount;

    static {
        BankAccount.rate = DEFAULT_INTEREST;
        BankAccount.bankAccountCount = 0;
    }

    private int id;
    private double balance;

    BankAccount() {
        this.setId();
        this.balance = 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = ++ bankAccountCount;
    }

    public static void setInterest(double interest) {
        BankAccount.rate = interest;
    }

    public double getInterest(int years) {
        return this.balance * BankAccount.rate * years;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}
