package sorting_algorithms.assignment_problems;

import java.util.Arrays;

/**
 * Problem 1: The Notice Board Shuffle
 * 
 * Sorts scores in ascending order using Bubble Sort with early termination.
 * Returns {passes, swaps}: total passes performed and total swaps made.
 * 
 * Time Complexity:
 * - Best Case (already sorted): O(n) - only 1 pass with 0 swaps.
 * - Worst / Average Case: O(n^2) - up to n passes and n*(n-1)/2 swaps.
 * Extra Space Complexity: O(1) auxiliary space (in-place).
 * Stability: Stable (adjacent elements swapped only when scores[j] > scores[j+1]).
 * 
 * Why an already-sorted board needs only one pass:
 * The swapped flag is set to false at the start of each pass. When the array is already sorted,
 * no adjacent pair violates the ordering condition (scores[j] <= scores[j+1] for all j).
 * Therefore, no swap occurs, the swapped flag remains false, and the algorithm breaks out
 * immediately after the first pass.
 */
public class NoticeBoardShuffle {

    public static int[] bubbleStats(int[] scores) {
        if (scores == null || scores.length <= 1) {
            return new int[]{scores == null || scores.length == 0 ? 0 : 1, 0};
        }

        int n = scores.length;
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            passes++;
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return new int[]{passes, swaps};
    }

    public static void printExecution(int[] scores) {
        int[] stats = bubbleStats(scores);
        System.out.println(Arrays.toString(scores) + " passes = " + stats[0] + ", swaps = " + stats[1]);
    }

    public static void main(String[] args) {
        // Sample 1: scores = [5, 1, 4, 2, 8]
        // Expected Output: [1, 2, 4, 5, 8] passes = 3, swaps = 4
        int[] scores1 = {5, 1, 4, 2, 8};
        printExecution(scores1);

        // Sample 2: scores = [1, 2, 3, 4]
        // Expected Output: [1, 2, 3, 4] passes = 1, swaps = 0
        int[] scores2 = {1, 2, 3, 4};
        printExecution(scores2);
    }
}
