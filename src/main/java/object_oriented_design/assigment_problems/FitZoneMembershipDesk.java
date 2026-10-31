package object_oriented_design.assigment_problems;

/**
 * Question 4: The FitZone Membership Desk
 * 
 * Implements gym membership plans, status lifecycles (Active, Frozen, Expired),
 * and check-in access control guards.
 */
public class FitZoneMembershipDesk {

    public static void main(String[] args) {
        GymMember asha = new GymMember("Asha");
        GymMember ravi = new GymMember("Ravi");

        MembershipPlan quarterly = new QuarterlyPlan();
        MembershipPlan monthly = new MonthlyPlan();

        Membership mAsha = new Membership(asha, quarterly);
        Membership mRavi = new Membership(ravi, monthly);

        mAsha.checkIn();
        mAsha.freeze();
        mAsha.checkIn();

        mRavi.expire();
        mRavi.freeze();
    }
}

class GymMember {
    private String name;

    public GymMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface MembershipPlan {
    String getName();
    int getMonths();
    double calculateFee();
}

class MonthlyPlan implements MembershipPlan {
    @Override public String getName() { return "Monthly"; }
    @Override public int getMonths() { return 1; }
    @Override public double calculateFee() { return 1000.0; }
}

class QuarterlyPlan implements MembershipPlan {
    @Override public String getName() { return "Quarterly"; }
    @Override public int getMonths() { return 3; }
    @Override public double calculateFee() { return 3 * 1000.0 * 0.90; } // ₹2,700.00
}

class AnnualPlan implements MembershipPlan {
    @Override public String getName() { return "Annual"; }
    @Override public int getMonths() { return 12; }
    @Override public double calculateFee() { return 12 * 1000.0 * 0.75; } // ₹9,000.00
}

enum MembershipStatus {
    ACTIVE,
    FROZEN,
    EXPIRED
}

class Membership {
    private GymMember member;
    private MembershipPlan plan;
    private MembershipStatus status;
    private double fee;

    public Membership(GymMember member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.status = MembershipStatus.ACTIVE;
        this.fee = plan.calculateFee();
        System.out.printf("%s membership created for %s. Fee: ₹%,.2f. Status: %s.%n",
                plan.getName(), member.getName(), fee, getStatusString());
    }

    public String getStatusString() {
        if (status == MembershipStatus.ACTIVE) return "Active";
        if (status == MembershipStatus.FROZEN) return "Frozen";
        return "Expired";
    }

    public void checkIn() {
        if (status == MembershipStatus.ACTIVE) {
            System.out.println(member.getName() + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.getName() + "'s membership is " + getStatusString() + ".");
        }
    }

    public void freeze() {
        if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        if (status == MembershipStatus.ACTIVE) {
            this.status = MembershipStatus.FROZEN;
            System.out.println(member.getName() + "'s membership frozen. Status: Frozen.");
        }
    }

    public void unfreeze() {
        if (status == MembershipStatus.FROZEN) {
            this.status = MembershipStatus.ACTIVE;
            System.out.println(member.getName() + "'s membership unfrozen. Status: Active.");
        }
    }

    public void expire() {
        this.status = MembershipStatus.EXPIRED;
        System.out.println(member.getName() + "'s membership expired. Status: Expired.");
    }
}
