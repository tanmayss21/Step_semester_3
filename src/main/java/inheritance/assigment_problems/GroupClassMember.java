package inheritance.assigment_problems;

/**
 * Problem 5: Membership Numbers, Referral Codes & the Weekly Check-in Settlement
 * 
 * Hierarchical subclass extending GymMember directly. Models group class memberships
 * and provides batch check-in reconciliation with null-safety and instanceof dispatch.
 */
public class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String displayInfo() {
        if (GymMember.useShortFormat) {
            return "Group Class | Class: " + className + " | Sessions: " + sessionsAttended;
        }
        return "Group Class Member | Class: " + className + " | Sessions: " + sessionsAttended;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        if (members == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (GymMember member : members) {
            if (member == null) {
                nullSkipped++;
            } else {
                processed++;
                if (member instanceof GroupClassMember) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(isValidReferralCode("G45B"));
        System.out.println(isValidReferralCode("G4B"));
        System.out.println(isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        GymMember[] batch = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };
        System.out.println(processWeeklyCheckIn(batch));
    }
}
