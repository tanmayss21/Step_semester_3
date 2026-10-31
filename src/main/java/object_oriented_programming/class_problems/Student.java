package object_oriented_programming.class_problems;

/**
 * Problem M5: Instance vs Static: Splitting a Class Correctly
 * 
 * Separates instance state (name, attendance) from shared static
 * data (collegeName, studentCount) and static access methods.
 */
public class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Aarav", 85);
        new Student("Diya", 92);

        Student.printCollegeInfo();
    }
}
