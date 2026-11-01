package sorting_algorithms.assignment_problems;

/**
 * Problem 5: The Contest Leaderboard
 * 
 * Generates contest leaderboard sorted by marks in descending order (100 down to 0)
 * using Counting Sort without element-by-element comparisons.
 * Preserves submission order for equal marks (Stable).
 * 
 * Time Complexity: O(n + 101) linear time.
 * Extra Space Complexity: O(n + 101) auxiliary space (count array of size 101 + output array).
 * Stability: Stable (walking input array from right to left maintains submission tie order).
 */
public class ContestLeaderboard {

    public static class Entry {
        public String name;
        public int marks;

        public Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " " + marks;
        }
    }

    /**
     * Sorts contest entries in descending order of marks using Counting Sort in O(n + 101) time.
     * Preserves submission order for ties.
     */
    public static Entry[] leaderboard(Entry[] entries) {
        if (entries == null || entries.length <= 1) {
            return entries;
        }

        int n = entries.length;
        int maxKey = 100; // marks range from 0 to 100 -> keys range from 0 to 100
        int[] count = new int[maxKey + 1];

        // 1. Frequency count of transformed keys (key = 100 - marks)
        for (Entry entry : entries) {
            int key = 100 - entry.marks;
            count[key]++;
        }

        // 2. Cumulative count
        for (int i = 1; i <= maxKey; i++) {
            count[i] += count[i - 1];
        }

        // 3. Build output array walking right to left for stability
        Entry[] output = new Entry[n];
        for (int i = n - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            output[count[key] - 1] = entries[i];
            count[key]--;
        }

        return output;
    }

    public static String formatLeaderboard(Entry[] entries) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entries.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(entries[i].toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Input: Asha 90, Ravi 75, Neha 90, Kiran 100, Meera 75
        // Expected Output: Kiran 100, Asha 90, Neha 90, Ravi 75, Meera 75
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        Entry[] result = leaderboard(entries);
        System.out.println(formatLeaderboard(result));
    }
}
