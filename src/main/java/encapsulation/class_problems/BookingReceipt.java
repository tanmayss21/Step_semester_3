package encapsulation.class_problems;

import java.util.Arrays;

/**
 * Problem 5: Immutable Booking Receipt & Nightly Settlement
 * 
 * Demonstrates immutability through defensive copying, the with-style mutator pattern,
 * and safe aggregation with instanceof dispatch and null-safety.
 */
public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers != null ? seatNumbers.clone() : new String[0];
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers != null ? seatNumbers.clone() : new String[0];
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (seatNumbers == null || index < 0 || index >= seatNumbers.length) {
            return this;
        }
        String[] updated = seatNumbers.clone();
        updated[index] = newSeat;
        return new BookingReceipt(this.bookingId, updated);
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof GroupBookingReceipt) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]); // A1

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(b.getSeatNumbers()));       // [A1, A2]
        System.out.println(Arrays.toString(updated.getSeatNumbers())); // [A1, A3]

        BookingReceipt[] batch = new BookingReceipt[]{
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}
