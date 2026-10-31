package linked_list.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem 3: Student Club Registration Management
 * 
 * Prevents duplicate student registrations by identifying students solely by rollNumber.
 * Overrides equals() and hashCode() on Student to guarantee correct Set deduplication.
 */
public class StudentClubRegistrationManagement {

    public static class Student {
        private final String rollNumber;
        private final String name;

        public Student(String rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(rollNumber, student.rollNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rollNumber);
        }

        @Override
        public String toString() {
            return "Student[roll=" + rollNumber + ", name=" + name + "]";
        }
    }

    private final Set<Student> members = new HashSet<>();
    private boolean memberCountReported = false;

    public void addMember(String rollNumber, String name) {
        Student newStudent = new Student(rollNumber, name);
        if (members.add(newStudent)) {
            System.out.println("Added");
        } else {
            System.out.println("duplicate rejected");
        }
    }

    public void reportMemberCount() {
        if (!memberCountReported) {
            System.out.println("member count " + members.size());
            memberCountReported = true;
        }
    }

    public void containsMember(String rollNumber, String name) {
        reportMemberCount();
        Student probe = new Student(rollNumber, name);
        boolean found = members.contains(probe);
        System.out.println("contains: " + found);
    }

    public void processCommand(String line) {
        if (line == null || line.trim().isEmpty()) {
            return;
        }
        String[] parts = line.trim().split("\\s+");
        String command = parts[0].toUpperCase();

        if (command.equals("ADD")) {
            String rollNumber = parts[1];
            String name = parts.length > 2 ? parts[2] : "";
            addMember(rollNumber, name);
        } else if (command.equals("CONTAINS")) {
            String rollNumber = parts[1];
            String name = parts.length > 2 ? parts[2] : "";
            containsMember(rollNumber, name);
        }
    }

    public static void main(String[] args) {
        StudentClubRegistrationManagement manager = new StudentClubRegistrationManagement();

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        manager.processCommand(line);
                    }
                }
                manager.reportMemberCount();
                scanner.close();
                return;
            }
        } catch (Exception ignored) {}

        // Default sample execution
        String[] sampleOperations = {
            "ADD 21CS01 Asha",
            "ADD 21CS01 Asha",
            "ADD 21CS02 Ravi",
            "CONTAINS 21CS02 Ravi",
            "CONTAINS 21CS03 Priya"
        };
        for (String op : sampleOperations) {
            manager.processCommand(op);
        }
    }
}
