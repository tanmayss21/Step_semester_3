package data_structures.class_problems;

/**
 * Problem 5: Maximize Area Between Two Boundaries (Container With Most Water)
 * 
 * Computes maximum water container volume using the optimal two-pointer technique
 * in O(n) time and O(1) space.
 */
public class ContainerWithMostWater {

    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currentArea = width * height;
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights)); // 49
    }
}
