package data_structures.assigment_problems;

/**
 * Problem 1: Class Topper Finder
 * 
 * Traverses a 2D marks grid to determine the student with the highest total marks,
 * breaking ties with the smallest row index in O(m * n) time and O(1) space.
 */
public class ClassTopperFinder {

    public static class TopperResult {
        public final int rowIndex;
        public final int total;

        public TopperResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    public static TopperResult findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new TopperResult(-1, 0);
        }

        int bestIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            if (marks[i] != null) {
                for (int score : marks[i]) {
                    currentTotal += score;
                }
            }

            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestIndex = i;
            }
        }

        return new TopperResult(bestIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        System.out.println(findTopper(marks)); // (1, 259)
    }
}
