package week1.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);
            if (ch == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxColor = currentColor;
                }
                currentColor = ch;
                currentStreak = 1;
            }
        }

        // Check streak at the end of the string
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxColor = currentColor;
        }

        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        System.out.println("=== Traffic Signal Streak Analyzer ===\n");

        System.out.print("Input: \"RRGGGYRR\" -> Output: ");
        findLongestStreak("RRGGGYRR");

        System.out.print("Input: \"RRRRYYGG\" -> Output: ");
        findLongestStreak("RRRRYYGG");
    }
}
