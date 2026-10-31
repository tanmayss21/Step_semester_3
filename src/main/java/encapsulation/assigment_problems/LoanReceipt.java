package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Problem 5: Immutable Loan Receipt & Nightly Circulation Ledger
 * 
 * Demonstrates immutability with defensive copying, with-style updates,
 * static initialization blocks, and safe batch aggregation.
 */
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null ? bookIds.clone() : new String[0];
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds != null ? bookIds.clone() : new String[0];
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (bookIds == null || index < 0 || index >= bookIds.length) {
            return this;
        }
        String[] updated = bookIds.clone();
        updated[index] = newId;
        return new LoanReceipt(this.memberId, updated);
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        return CirculationLedger.processNightlyCirculation(receipts);
    }

    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]); // BK-100

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(r.getBookIds()));         // [BK-100, BK-101]
        System.out.println(Arrays.toString(corrected.getBookIds())); // [BK-100, BK-102]

        LoanReceipt[] batch = new LoanReceipt[]{
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(batch));
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {
    private static String defaultBranchCode;

    static {
        defaultBranchCode = "MAIN-CIRCULATION-01";
    }

    public static String getDefaultBranchCode() {
        return defaultBranchCode;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 reference-only | 0 regular";
        }

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnlyCount = 0;
        int regularCount = 0;

        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnlyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnlyCount + " reference-only | " + regularCount + " regular";
    }
}
