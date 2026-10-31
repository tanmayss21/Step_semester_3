package string.class_problems;

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            System.out.println("Invalid: wrong length");
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters");
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Input: \" hdf03022600042 \"");
        String code1 = normalizeReference(" hdf03022600042 ");
        validateAndFormat(code1);

        System.out.println("\nInput: \"12F03022600042\"");
        String code2 = normalizeReference("12F03022600042");
        validateAndFormat(code2);
    }
}
