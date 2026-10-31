package data_structures.assigment_problems;

/**
 * Problem 4: Hot Weather Alert Windows
 * 
 * Uses the sliding window technique to count qualifying k-hour contiguous blocks
 * whose average meets or exceeds the threshold in O(n) time and O(1) space.
 */
public class HotWeatherAlertWindows {

    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k || k <= 0) {
            return 0;
        }

        long targetSum = (long) k * threshold;
        long currentWindowSum = 0;

        for (int i = 0; i < k; i++) {
            currentWindowSum += readings[i];
        }

        int alertCount = 0;
        if (currentWindowSum >= targetSum) {
            alertCount++;
        }

        for (int i = k; i < readings.length; i++) {
            currentWindowSum += readings[i] - readings[i - k];
            if (currentWindowSum >= targetSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println(countAlerts(readings, k, threshold)); // 3
    }
}
