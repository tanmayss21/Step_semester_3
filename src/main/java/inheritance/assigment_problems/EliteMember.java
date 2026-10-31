package inheritance.assigment_problems;

/**
 * Problem 2: Three Tiers of Gym Membership
 * 
 * Demonstrates multilevel inheritance extending PremiumMember,
 * generation classification via instanceof, and polymorphic session summation.
 */
public class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    @Override
    public String displayInfo() {
        if (GymMember.useShortFormat) {
            return "Elite | Trainer: " + getTrainerName() + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
        }
        return "Elite Member | Trainer: " + getTrainerName() + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
    }

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof PremiumMember) {
            return "Direct child (2 generations deep)";
        }
        return "Root generation (base class)";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        if (members == null) {
            return 0;
        }
        int total = 0;
        for (GymMember m : members) {
            if (m != null) {
                total += m.getSessionsAttended();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new GymMember("MEM1", 1000).displayInfo());
        System.out.println(new PremiumMember("MEM2", 2000, "Coach Riya").displayInfo());
        System.out.println(new EliteMember("MEM3", 3000, "Coach Arjun", "L12").displayInfo());
        System.out.println(new GroupClassMember("MEM4", 1500, "Zumba").displayInfo());

        EliteMember eliteMember = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClassMember = new GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(classifyGeneration(eliteMember));
        System.out.println(classifyGeneration(groupClassMember));

        PremiumMember premiumMember = new PremiumMember("MEM5", 2000, "Coach Riya");
        premiumMember.attendSession();
        premiumMember.attendSession();
        premiumMember.attendSession();

        eliteMember.attendSession();
        eliteMember.attendSession();

        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();

        GymMember[] list = { premiumMember, eliteMember, groupClassMember };
        System.out.println(getTotalSessionsAttended(list));
    }
}
