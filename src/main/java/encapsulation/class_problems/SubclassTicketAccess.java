package encapsulation.class_problems;

/**
 * Problem 2: Subclass Ticket Access
 * 
 * Extends access checking to cross-package subclass contexts:
 * - SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE (allowed for protected)
 * - SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE (denied for protected)
 * Handles 5 contexts total.
 */
public class SubclassTicketAccess {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier.toLowerCase()) {
            case "public":
                return "ALLOWED";

            case "protected":
                if ("SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext)
                        || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "default":
                if ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "private":
                if ("SAME_CLASS".equals(accessorContext)) {
                    return "ALLOWED";
                }
                return "DENIED";

            default:
                return "DENIED";
        }
    }

    public static void main(String[] args) {
        System.out.println("Protected via OWN_TYPE: "
                + classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println("Protected via PARENT_TYPE: "
                + classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}

class PremiumMovieTicket extends MovieTicket {
    private double discountRate;

    public PremiumMovieTicket(int seatNumber, String screenId, double ticketPrice, String movieTitle, double discountRate) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
        this.discountRate = discountRate;
    }

    public double getDiscountedPrice() {
        return this.ticketPrice * (1.0 - discountRate);
    }
}
