package constructors_and_keywords.class_problems;

/**
 * Problem M3: Late Fees - Skip the On-Time Accounts
 * 
 * Demonstrates the final keyword to lock down fee calculation and receipt printing
 * against subclass overrides, combined with conditional skip logic.
 */
public class LateFeeAccount {
    String regNo;
    double totalFee;

    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public final double calculateLateFee(int daysLate) {
        // Late fee is 1% of total tuition fee per day overdue
        return this.totalFee * 0.01 * daysLate;
    }

    public final void printSummary(int daysLate) {
        double lateFee = calculateLateFee(daysLate);
        System.out.println(this.regNo + " | Total Fee: Rs " + this.totalFee + " | Late Fee: Rs " + lateFee);
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            LateFeeAccount account = new LateFeeAccount(regNos[i], totalFees[i]);
            if (daysLate[i] <= 0) {
                System.out.println(regNos[i] + " - On time, no late fee");
            } else {
                account.printSummary(daysLate[i]);
            }
        }
    }
}
