package string.class_problems;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            System.out.println("Invalid phone number");
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                System.out.println("Invalid phone number");
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Input: \"9876543210\"");
        maskPhoneNumber("9876543210");

        System.out.println("\nInput: \"98765\"");
        maskPhoneNumber("98765");
    }
}
