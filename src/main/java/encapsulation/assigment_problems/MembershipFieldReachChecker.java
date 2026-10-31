package encapsulation.assigment_problems;

/**
 * Problem 1: Membership Field Reach Checker
 * 
 * Verifies access levels for LibraryMember fields and aggregates batch results
 * grouped by access modifier.
 */
public class MembershipFieldReachChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier.toLowerCase()) {
            case "public":
                return "ALLOWED";

            case "protected":
                if ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) {
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

    public static String summarizeByModifier(String[][] attempts) {
        int privAllow = 0, privDeny = 0;
        int defAllow = 0, defDeny = 0;
        int protAllow = 0, protDeny = 0;
        int pubAllow = 0, pubDeny = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String mod = attempt[0] != null ? attempt[0].toLowerCase() : "";
                    String ctx = attempt[1];
                    String result = classifyAccess(mod, ctx);
                    boolean isAllowed = "ALLOWED".equals(result);

                    switch (mod) {
                        case "private":
                            if (isAllowed) privAllow++; else privDeny++;
                            break;
                        case "default":
                            if (isAllowed) defAllow++; else defDeny++;
                            break;
                        case "protected":
                            if (isAllowed) protAllow++; else protDeny++;
                            break;
                        case "public":
                            if (isAllowed) pubAllow++; else pubDeny++;
                            break;
                    }
                }
            }
        }

        return String.format(
            "private: %d allowed / %d denied | default: %d allowed / %d denied | protected: %d allowed / %d denied | public: %d allowed / %d denied",
            privAllow, privDeny, defAllow, defDeny, protAllow, protDeny, pubAllow, pubDeny
        );
    }

    public static class LibraryMember {
        private int membershipPin;
        String branchCode;
        protected double finesOwed;
        public String displayName;

        public LibraryMember(int membershipPin, String branchCode, double finesOwed, String displayName) {
            this.membershipPin = membershipPin;
            this.branchCode = branchCode;
            this.finesOwed = finesOwed;
            this.displayName = displayName;
        }

        public int getMembershipPin() {
            return membershipPin;
        }
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(batch));
    }
}
