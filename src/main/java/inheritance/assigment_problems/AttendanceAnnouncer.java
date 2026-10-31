package inheritance.assigment_problems;

/**
 * Problem 4: The Monthly Attendance Announcer
 * 
 * Generates monthly gym announcements using polymorphic displayInfo() calls
 * with safe downcasting guarded by instanceof checks.
 */
public class AttendanceAnnouncer {

    public static String batchPrint(GymMember[] members) {
        if (members == null) {
            return "";
        }

        GymMember.useShortFormat = true;
        try {
            StringBuilder sb = new StringBuilder();
            for (GymMember member : members) {
                if (member != null) {
                    sb.append(member.displayInfo());
                    if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
                    }
                    sb.append(" | ");
                }
            }
            return sb.toString();
        } finally {
            GymMember.useShortFormat = false;
        }
    }

    public static void main(String[] args) {
        GymMember[] list = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(list));

        try {
            GymMember plain = new GymMember("MEM8", 1000);
            PremiumMember bad = (PremiumMember) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}
