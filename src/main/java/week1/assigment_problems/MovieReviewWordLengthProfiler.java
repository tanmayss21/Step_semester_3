package week1.assigment_problems;

public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Clean non-letter characters if present (like punctuation)
            String cleaned = word.replaceAll("[^a-zA-Z]", "");
            int length = cleaned.isEmpty() ? word.length() : cleaned.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Movie Review Word Length Profiler ===\n");

        String sampleReview = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + sampleReview + "\"");
        System.out.print("Output: ");
        classifyWordLengths(sampleReview);
    }
}
