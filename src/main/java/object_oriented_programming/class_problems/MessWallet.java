package object_oriented_programming.class_problems;

/**
 * Problem M2: Encapsulated Mess-Card Wallet
 * 
 * Enforces encapsulation with a private balance, validated top-up operations,
 * and overdraft prevention so balance never goes negative.
 */
public class MessWallet {
    private double balance;

    public MessWallet(double initialBalance) {
        if (initialBalance < 0.0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0.0) {
            System.out.println("Top-up rejected: amount must be positive.");
            return;
        }
        this.balance += amount;
        System.out.println("Balance after top-up: " + this.balance);
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        MessWallet studentWallet = new MessWallet(500);
        studentWallet.topUp(200);
        studentWallet.deduct(1000);
        System.out.println("Final balance: " + studentWallet.getBalance());
    }
}
