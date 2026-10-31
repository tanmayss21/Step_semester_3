package week1.class_problems;

import java.util.Locale;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        int count = Math.min(heights.length, weights.length);

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf(Locale.US, "%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf(Locale.US, "Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n", (i + 1), h, w, bmi, status);
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Corporate Wellness Program - BMI Report ===\n");

        // Demonstration with 10 members including the sample cases
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.58};
        double[] weights = {70.0, 90.0, 65.0, 50.0, 82.0, 42.0, 95.0, 68.0, 74.0, 62.0};

        printWellnessReport(heights, weights);
    }
}
