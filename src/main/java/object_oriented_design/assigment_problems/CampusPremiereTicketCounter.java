package object_oriented_design.assigment_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question 3: The Campus Premiere Ticket Counter
 * 
 * Manages movie seat bookings with category-based pricing, duplicate booking guards,
 * and cancellation workflows that release seats.
 */
public class CampusPremiereTicketCounter {

    public static void main(String[] args) {
        AuditoriumCustomer asha = new AuditoriumCustomer("Asha");
        AuditoriumCustomer ravi = new AuditoriumCustomer("Ravi");
        AuditoriumCustomer neha = new AuditoriumCustomer("Neha");

        Show show7PM = new Show("7 PM Movie Show");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        Booking bAsha = show7PM.bookSeats(asha, List.of(a1, a2, f5));
        show7PM.bookSeats(ravi, List.of(a2));
        Booking bRavi = show7PM.bookSeats(ravi, List.of(r1));

        if (bAsha != null) {
            show7PM.cancelBooking(bAsha, true);
        }

        show7PM.bookSeats(neha, List.of(a2));
    }
}

class AuditoriumCustomer {
    private String name;

    public AuditoriumCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Seat {
    protected String seatCode;

    public Seat(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public abstract double getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatCode != null ? seatCode.equals(seat.seatCode) : seat.seatCode == null;
    }

    @Override
    public int hashCode() {
        return seatCode != null ? seatCode.hashCode() : 0;
    }
}

class RegularSeat extends Seat {
    public RegularSeat(String seatCode) { super(seatCode); }
    @Override public double getPrice() { return 150.0; }
}

class PremiumSeat extends Seat {
    public PremiumSeat(String seatCode) { super(seatCode); }
    @Override public double getPrice() { return 250.0; }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(String seatCode) { super(seatCode); }
    @Override public double getPrice() { return 400.0; }
}

class Show {
    private String title;
    private Set<String> bookedSeats = new HashSet<>();
    private List<Booking> bookings = new ArrayList<>();

    public Show(String title) {
        this.title = title;
    }

    public Booking bookSeats(AuditoriumCustomer customer, List<Seat> requestedSeats) {
        if (requestedSeats.size() > 6) {
            System.out.println("Cannot book more than 6 seats per booking.");
            return null;
        }

        for (Seat s : requestedSeats) {
            if (bookedSeats.contains(s.getSeatCode())) {
                System.out.println("Seat " + s.getSeatCode() + " is already booked for this show.");
                return null;
            }
        }

        double total = 0;
        List<String> codes = new ArrayList<>();
        for (Seat s : requestedSeats) {
            bookedSeats.add(s.getSeatCode());
            codes.add(s.getSeatCode());
            total += s.getPrice();
        }

        Booking booking = new Booking(customer, this, requestedSeats, total);
        bookings.add(booking);
        System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.%n",
                customer.getName(), String.join(", ", codes), total);
        return booking;
    }

    public void cancelBooking(Booking booking, boolean beforeShowStarts) {
        if (!beforeShowStarts) {
            System.out.println("Cannot cancel booking after the show has started.");
            return;
        }

        List<String> codes = new ArrayList<>();
        for (Seat s : booking.getSeats()) {
            bookedSeats.remove(s.getSeatCode());
            codes.add(s.getSeatCode());
        }
        bookings.remove(booking);
        System.out.printf("%s's booking cancelled. Seats %s released.%n",
                booking.getCustomer().getName(), String.join(", ", codes));
    }
}

class Booking {
    private AuditoriumCustomer customer;
    private Show show;
    private List<Seat> seats;
    private double totalAmount;

    public Booking(AuditoriumCustomer customer, Show show, List<Seat> seats, double totalAmount) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        this.totalAmount = totalAmount;
    }

    public AuditoriumCustomer getCustomer() {
        return customer;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
