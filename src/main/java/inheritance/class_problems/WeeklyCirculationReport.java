package inheritance.class_problems;

/**
 * Problem 4: The Weekly Circulation Report
 * 
 * Generates aggregated circulation reports using polymorphic displayInfo() calls
 * with safe downcasting guarded by instanceof checks.
 */
public class WeeklyCirculationReport {

    public static String batchPrint(LibraryMember[] members) {
        if (members == null) {
            return "";
        }

        LibraryMember.useShortFormat = true;
        try {
            StringBuilder sb = new StringBuilder();
            for (LibraryMember member : members) {
                if (member != null) {
                    sb.append(member.displayInfo());
                    if (member instanceof StudentMember) {
                        StudentMember sm = (StudentMember) member;
                        sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
                    }
                    sb.append(" | ");
                }
            }
            return sb.toString();
        } finally {
            LibraryMember.useShortFormat = false;
        }
    }

    public static void main(String[] args) {
        LibraryMember[] list = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(list));

        try {
            LibraryMember plain = new LibraryMember("LB6", 3);
            StudentMember bad = (StudentMember) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}
