package constructors_and_keywords.class_problems;

/**
 * Problem M5: Account Batch Payments
 * 
 * Uses instanceof type checking to inspect runtime object types within a collection
 * and dispatch specialized payment behavior alongside tracking statistics.
 */
public class FeeAccount {

    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.pay(amount);
        } else {
            account.pay(amount);
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double paymentAmount = 60000;
        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeeAccount account : accounts) {
            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
            processPayment(account, paymentAmount);
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}
