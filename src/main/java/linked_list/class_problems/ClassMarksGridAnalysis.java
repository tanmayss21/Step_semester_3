package linked_list.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4: Class Marks Grid Analysis
 * 
 * Manages and analyzes student marks across multiple subjects using a 2D array/grid:
 * - Calculates individual total marks for each student.
 * - Computes average marks per subject formatted to two decimal places.
 * - Identifies the class topper with highest total marks.
 */
public class ClassMarksGridAnalysis {

    public static class StudentRecord {
        String name;
        int[] marks;
        int total;

        public StudentRecord(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
            int sum = 0;
            for (int m : marks) {
                sum += m;
            }
            this.total = sum;
        }
    }

    public static void analyzeAndPrint(List<StudentRecord> students) {
        if (students == null || students.isEmpty()) {
            return;
        }

        int numStudents = students.size();
        int numSubjects = students.get(0).marks.length;

        // 1. Build 2D grid
        int[][] grid = new int[numStudents][numSubjects];
        for (int i = 0; i < numStudents; i++) {
            grid[i] = students.get(i).marks;
        }

        // 2. Report individual totals & find topper
        StringBuilder totalsSb = new StringBuilder("Totals ");
        StudentRecord topper = students.get(0);

        for (int i = 0; i < numStudents; i++) {
            StudentRecord s = students.get(i);
            if (i > 0) {
                totalsSb.append(", ");
            }
            totalsSb.append(s.name).append(" ").append(s.total);

            if (s.total > topper.total) {
                topper = s;
            }
        }
        System.out.println(totalsSb.toString());

        // 3. Compute subject averages
        StringBuilder averagesSb = new StringBuilder("averages ");
        for (int j = 0; j < numSubjects; j++) {
            double subjectSum = 0;
            for (int i = 0; i < numStudents; i++) {
                subjectSum += grid[i][j];
            }
            double avg = subjectSum / numStudents;
            if (j > 0) {
                averagesSb.append(", ");
            }
            averagesSb.append(String.format(Locale.US, "%.2f", avg));
        }
        System.out.println(averagesSb.toString());

        // 4. Print topper
        System.out.println("topper " + topper.name + " (" + topper.total + ")");
    }

    public static StudentRecord parseLine(String line) {
        line = line.trim();
        int bracketStart = line.indexOf('[');
        int bracketEnd = line.indexOf(']');
        if (bracketStart == -1 || bracketEnd == -1) {
            return null;
        }
        String name = line.substring(0, bracketStart).trim();
        String marksPart = line.substring(bracketStart + 1, bracketEnd);
        String[] tokens = marksPart.split(",");
        int[] marks = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            marks[i] = Integer.parseInt(tokens[i].trim());
        }
        return new StudentRecord(name, marks);
    }

    public static void main(String[] args) {
        List<StudentRecord> students = new ArrayList<>();

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) {
                        continue;
                    }
                    StudentRecord record = parseLine(line);
                    if (record != null) {
                        students.add(record);
                    }
                }
                scanner.close();
            }
        } catch (Exception ignored) {}

        if (students.isEmpty()) {
            // Default sample execution
            students.add(new StudentRecord("Asha", new int[]{78, 85, 90}));
            students.add(new StudentRecord("Ravi", new int[]{88, 92, 79}));
            students.add(new StudentRecord("Neha", new int[]{65, 70, 95}));
        }

        analyzeAndPrint(students);
    }
}
