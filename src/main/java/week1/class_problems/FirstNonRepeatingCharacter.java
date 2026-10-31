package week1.class_problems;

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Array-based frequency table for ASCII characters
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                frequency[ch]++;
            }
        }

        // Early-exit scan to find the first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void checkAndDisplay(String text) {
        System.out.println("Input: \"" + text + "\"");
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt - First Non-Repeating Character ===\n");

        // Sample inputs from problem specification
        checkAndDisplay("swiss");
        checkAndDisplay("aabbcc");

        // Optional console input
        try {
            if (System.console() != null || System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine().trim();
                    if (!input.isEmpty()) {
                        checkAndDisplay(input);
                    }
                }
                scanner.close();
            }
        } catch (Exception ignored) {}
    }
}
