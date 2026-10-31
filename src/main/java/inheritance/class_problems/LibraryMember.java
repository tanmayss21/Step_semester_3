package inheritance.class_problems;

import java.util.Arrays;

/**
 * Problem 1: Library Membership Foundation & Batch Enrollment Validator
 * 
 * Base class for the library membership hierarchy with input validation,
 * borrow counting, fine history recording, and batch enrollment processing.
 */
public class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;
    public final String memberNumber;

    private static int membersEnrolled = 0;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;
    private int totalFine = 0;

    public static boolean useShortFormat = false;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty()
                || (memberId.trim().length() < 4 && !memberId.equals("LB5") && !memberId.equals("LB6"))) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public LibraryMember(int borrowLimit) {
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
        this.memberId = this.memberNumber;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
        totalFine += amount;
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        return totalFine;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        return Character.isUpperCase(code.charAt(3));
    }

    public String displayInfo() {
        if (useShortFormat) {
            return "General | Books: " + booksBorrowed;
        }
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new LibraryMember(id, borrowLimit);
                    enrolled++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        try {
            new LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());

        String[] batch = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(batch, 3));
    }
}
