package inheritance.class_problems;

import java.util.Arrays;

/**
 * Problem 3: The Student Discount & Fine Ledger
 * 
 * Subclass extending LibraryMember. Halves late fines via super.chargeFine()
 * and maintains course details and student display format.
 */
public class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    @Override
    public String displayInfo() {
        if (LibraryMember.useShortFormat) {
            return "Student | Course: " + course + " | Books: " + booksBorrowed;
        }
        return "Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed;
    }

    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}
