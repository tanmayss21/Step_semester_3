package sorting_algorithms.assignment_problems;

/**
 * Problem 3: The Attendance Disorder Score
 * 
 * Counts disorder pairs (inversions) where i < j and roll[i] > roll[j]
 * using a divide-and-conquer Merge Sort approach.
 * 
 * Time Complexity: O(n log n) in all cases (divides array log n times, merges in O(n)).
 * Extra Space Complexity: O(n) auxiliary space for merging.
 * Stability: Stable counting logic (preserves relative order of equal elements without false inversion counts).
 */
public class AttendanceDisorderScore {

    /**
     * Counts the total number of inversions in the roll array in O(n log n) time.
     */
    public static long countInversions(int[] roll) {
        if (roll == null || roll.length <= 1) {
            return 0;
        }
        int[] temp = new int[roll.length];
        int[] arr = roll.clone(); // preserve original input array
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // initial index of left subarray
        int j = mid + 1;  // initial index of right subarray
        int k = left;     // initial index of merged subarray
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in left half arr[i..mid] are greater than arr[j]
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        // Sample 1: roll = [2, 4, 1, 3, 5]
        // Expected Output: 3 (2>1, 4>1, 4>3)
        int[] roll1 = {2, 4, 1, 3, 5};
        System.out.println(countInversions(roll1));

        // Sample 2: roll = [5, 4, 3, 2, 1]
        // Expected Output: 10
        int[] roll2 = {5, 4, 3, 2, 1};
        System.out.println(countInversions(roll2));
    }
}
