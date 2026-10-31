package string.class_problems;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            System.out.println("Rejected - invalid file type");
            return "Rejected - invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            System.out.println("Rejected - invalid file type");
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            System.out.println("Accepted");
            return "Accepted";
        } else {
            System.out.println("Rejected - invalid file type");
            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("Input: \"Assignment1.PDF\"");
        validateFileExtension("Assignment1.PDF");

        System.out.println("\nInput: \"notes.txt\"");
        validateFileExtension("notes.txt");
    }
}
