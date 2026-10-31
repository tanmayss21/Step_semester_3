package data_structures.class_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem 4: Pair With Target Sum (Unsorted Array)
 * 
 * Compares two distinct algorithmic strategies for the target sum problem:
 * 1. Hash Set Approach: O(n) Time, O(n) Space.
 * 2. Two-Pointer Approach (with Sorting): O(n log n) Time, O(1) Extra Space.
 */
public class PairWithTargetSumTwoPointers {

    public static boolean hasPairWithSumHashing(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;

        int[] copy = nums.clone();
        Arrays.sort(copy);

        int left = 0;
        int right = copy.length - 1;

        while (left < right) {
            int sum = copy[left] + copy[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static boolean hasPairWithSum(int[] nums, int target) {
        return hasPairWithSumHashing(nums, target);
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("Hashing: " + hasPairWithSumHashing(nums1, 9));
        System.out.println("Two Pointers: " + hasPairWithSumTwoPointers(nums1, 9));

        int[] nums2 = {3, 4, 6};
        System.out.println("Hashing: " + hasPairWithSumHashing(nums2, 20));
        System.out.println("Two Pointers: " + hasPairWithSumTwoPointers(nums2, 20));
    }
}
