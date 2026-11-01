package sorting_algorithms.assignment_problems;

/**
 * Problem 4: The Placement Cutoff
 * 
 * Finds the k-th highest mark using the QuickSelect algorithm
 * (reusing QuickSort Lomuto partitioning with the last element as pivot).
 * 
 * Time Complexity:
 * - Average Case: O(n) (recursing/looping only on the relevant side).
 * - Worst Case: O(n^2) (pathological pivot choices).
 * Extra Space Complexity: O(1) auxiliary space (iterative loop).
 * Stability: Unstable (partitioning swaps non-adjacent elements across the pivot).
 */
public class PlacementCutoff {

    /**
     * Finds the k-th highest element in marks (1-based, duplicates count separately).
     * In ascending order, the k-th highest element sits at index (n - k).
     */
    public static int kthHighest(int[] marks, int k) {
        if (marks == null || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid input or k out of bounds.");
        }

        int[] arr = marks.clone(); // preserve original marks array
        int n = arr.length;
        int targetIndex = n - k; // 0-based index in ascending order

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int pivotIndex = partition(arr, low, high);

            if (pivotIndex == targetIndex) {
                return arr[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }

        return arr[low];
    }

    /**
     * Lomuto partition scheme using the last element as pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Sample 1: marks = [72, 95, 60, 88, 79], k = 2
        // Expected Output: 88
        int[] marks1 = {72, 95, 60, 88, 79};
        System.out.println(kthHighest(marks1, 2));

        // Sample 2: marks = [50, 90, 90, 70], k = 2
        // Expected Output: 90
        int[] marks2 = {50, 90, 90, 70};
        System.out.println(kthHighest(marks2, 2));
    }
}
