package inheritance.class_problems;

/**
 * Problem 2: Three Branches of the Membership Tree
 * 
 * Demonstrates multilevel inheritance extending StudentMember,
 * generation classification using instanceof, and polymorphic session summation.
 */
public class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    public int getBonusLimit() {
        return bonusLimit;
    }

    @Override
    public String displayInfo() {
        if (LibraryMember.useShortFormat) {
            return "Honors Student | Course: " + getCourse() + " | Bonus: " + bonusLimit + " | Books: " + getBooksBorrowed();
        }
        return "Honors Student Member | Course: " + getCourse() + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed();
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof StudentMember) {
            return "Direct child (2 generations deep)";
        }
        return "Root generation (base class)";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        if (members == null) {
            return 0;
        }
        int total = 0;
        for (LibraryMember m : members) {
            if (m != null) {
                total += m.getBooksBorrowed();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new LibraryMember("STU1", 3).displayInfo());
        System.out.println(new StudentMember("STU2", 3, "CSE").displayInfo());
        System.out.println(new HonorsStudentMember("STU3", 3, "ECE", 2).displayInfo());
        System.out.println(new FacultyMember("STU4", 5, "Physics").displayInfo());

        HonorsStudentMember honorsMember = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember facultyMember = new FacultyMember("STU4", 5, "Physics");

        System.out.println(classifyGeneration(honorsMember));
        System.out.println(classifyGeneration(facultyMember));

        StudentMember studentMember = new StudentMember("STU5", 3, "ME");
        studentMember.borrowBook();
        studentMember.borrowBook();

        honorsMember.borrowBook();

        facultyMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();

        LibraryMember[] list = { studentMember, honorsMember, facultyMember };
        System.out.println(getTotalBooksBorrowed(list));
    }
}
