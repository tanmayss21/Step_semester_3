package week1.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void displayReversal(String name) {
        String reversed = reverseCustomerName(name);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===\n");

        // Sample input from problem specification
        displayReversal("Sunil");

        // Additional test cases
        displayReversal("Alexander");

        // Optional console input
        try {
            if (System.console() != null || System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine().trim();
                    if (!input.isEmpty()) {
                        displayReversal(input);
                    }
                }
                scanner.close();
            }
        } catch (Exception ignored) {}
    }
}
