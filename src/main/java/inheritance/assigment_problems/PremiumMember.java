package inheritance.assigment_problems;

import java.util.Arrays;

/**
 * Problem 3: The Premium Loyalty Discount & Late-Fee Ledger
 * 
 * Subclass extending GymMember directly. Halves late fees via super.chargeLateFee()
 * and maintains trainer information and premium display formats.
 */
public class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }

    @Override
    public String displayInfo() {
        if (GymMember.useShortFormat) {
            return "Premium | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
        }
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}
