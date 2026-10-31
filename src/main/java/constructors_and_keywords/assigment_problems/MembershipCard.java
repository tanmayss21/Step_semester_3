package constructors_and_keywords.assigment_problems;

/**
 * Problem A4: Static Block - Library Membership Card Setup
 * 
 * Demonstrates a static initialization block to ensure library metadata
 * is loaded once into memory regardless of how many individual cards are printed.
 */
public class MembershipCard {
    static String libraryName;
    static String validUntil;
    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
        System.out.println("Membership card issued: " + this.studentName);
    }

    public static void main(String[] args) {
        String[] studentNames = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (String name : studentNames) {
            new MembershipCard(name);
        }
    }
}
