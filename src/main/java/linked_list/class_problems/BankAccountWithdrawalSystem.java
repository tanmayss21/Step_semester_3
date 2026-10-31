package linked_list.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem 1: Bank Account Withdrawal System
 * 
 * Manages Savings and Current accounts with withdrawal constraints:
 * - Savings Account: Minimum balance of 1000 must be maintained after withdrawal.
 * - Current Account: Overdraft limit of 5000 (balance can reach down to -5000).
 */
public class BankAccountWithdrawalSystem {

    public static abstract class Account {
        protected String id;
        protected double balance;

        public Account(String id, double balance) {
            this.id = id;
            this.balance = balance;
        }

        public String getId() {
            return id;
        }

        public double getBalance() {
            return balance;
        }

        public abstract void withdraw(double amount);
    }

    public static class SavingsAccount extends Account {
        private static final double MIN_BALANCE = 1000.0;

        public SavingsAccount(String id, double initialBalance) {
            super(id, initialBalance);
        }

        @Override
        public void withdraw(double amount) {
            if (balance - amount < MIN_BALANCE) {
                System.out.println(id + " rejected: minimum balance 1000");
            } else {
                balance -= amount;
                System.out.println(id + " balance " + formatBalance(balance));
            }
        }
    }

    public static class CurrentAccount extends Account {
        private static final double OVERDRAFT_LIMIT = 5000.0;

        public CurrentAccount(String id, double initialBalance) {
            super(id, initialBalance);
        }

        @Override
        public void withdraw(double amount) {
            if (balance - amount < -OVERDRAFT_LIMIT) {
                System.out.println(id + " rejected: overdraft limit 5000");
            } else {
                balance -= amount;
                System.out.println(id + " balance " + formatBalance(balance));
            }
        }
    }

    private static String formatBalance(double balance) {
        if (balance == (long) balance) {
            return String.format("%d", (long) balance);
        }
        return String.format("%.2f", balance);
    }

    private final Map<String, Account> accounts = new HashMap<>();

    public void processCommand(String line) {
        if (line == null || line.trim().isEmpty()) {
            return;
        }
        String[] parts = line.trim().split("\\s+");
        String command = parts[0];

        if ("Savings".equalsIgnoreCase(command)) {
            String id = parts[1];
            double initialBalance = Double.parseDouble(parts[2]);
            accounts.put(id, new SavingsAccount(id, initialBalance));
        } else if ("Current".equalsIgnoreCase(command)) {
            String id = parts[1];
            double initialBalance = Double.parseDouble(parts[2]);
            accounts.put(id, new CurrentAccount(id, initialBalance));
        } else if ("WITHDRAW".equalsIgnoreCase(command)) {
            String id = parts[1];
            double amount = Double.parseDouble(parts[2]);
            Account acc = accounts.get(id);
            if (acc == null) {
                System.out.println("Account not found");
            } else {
                acc.withdraw(amount);
            }
        }
    }

    public static void main(String[] args) {
        BankAccountWithdrawalSystem system = new BankAccountWithdrawalSystem();

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        system.processCommand(line);
                    }
                }
                scanner.close();
                return;
            }
        } catch (Exception ignored) {}

        // Default sample execution
        String[] sampleOperations = {
            "Savings S1 5000",
            "WITHDRAW S1 4500",
            "Current C1 2000",
            "WITHDRAW C1 6000",
            "WITHDRAW S1 3000",
            "WITHDRAW C1 2000"
        };
        for (String op : sampleOperations) {
            system.processCommand(op);
        }
    }
}
