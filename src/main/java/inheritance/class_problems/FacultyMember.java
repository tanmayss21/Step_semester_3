package inheritance.class_problems;

/**
 * Problem 5: Membership Numbers, Renewal Codes & the Nightly Circulation Audit
 * 
 * Hierarchical subclass extending LibraryMember. Represents faculty memberships
 * and provides batch audit processing with null-safety and instanceof dispatch.
 */
public class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String displayInfo() {
        if (LibraryMember.useShortFormat) {
            return "Faculty | Dept: " + department + " | Books: " + booksBorrowed;
        }
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + booksBorrowed;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        if (members == null) {
            return "0 processed | 0 null skipped | 0 faculty | 0 regular";
        }

        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        for (LibraryMember member : members) {
            if (member == null) {
                nullSkipped++;
            } else {
                processed++;
                if (member instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + facultyCount + " faculty | " + regularCount + " regular";
    }

    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(isValidRenewalCode("R12A"));
        System.out.println(isValidRenewalCode("R1A"));
        System.out.println(isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());

        LibraryMember[] batch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println(processNightlyAudit(batch));
    }
}
