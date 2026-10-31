package constructors_and_keywords.class_problems;

/**
 * Problem M4: One-Time College Setup, Many Students
 * 
 * Demonstrates a static initialization block to perform one-time class loading
 * and configuration across multiple object creations.
 */
public class SrmStudent {
    static String collegeName;
    static String academicYear;
    String name;

    static {
        collegeName = "SRM University";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + this.name);
    }

    public static void main(String[] args) {
        String[] studentNames = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String studentName : studentNames) {
            new SrmStudent(studentName);
        }
    }
}
