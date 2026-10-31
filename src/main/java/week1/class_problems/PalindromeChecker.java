package week1.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative Comparison
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursion
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Character Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return Arrays.equals(original, reversed);
    }

    private static String formatResult(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void checkAndPrint(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean arr = isPalindromeArrayReversal(text);

        System.out.println("Input: \"" + text + "\"");
        System.out.println("Iterative: " + formatResult(iter) + " | Recursive: " + formatResult(rec) + " | Array Reversal: " + formatResult(arr));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Palindrome Checker (3 Approaches) ===\n");

        // Sample inputs from problem specification
        checkAndPrint("madam");
        checkAndPrint("hello");

        // Optional interactive input if provided
        try {
            if (System.console() != null || System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    String userText = scanner.nextLine().trim();
                    if (!userText.isEmpty()) {
                        checkAndPrint(userText);
                    }
                }
                scanner.close();
            }
        } catch (Exception ignored) {}
    }
}
