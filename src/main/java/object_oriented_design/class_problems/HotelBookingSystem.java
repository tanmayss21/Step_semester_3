package object_oriented_design.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 4: Hotel Booking System
 * 
 * Manages room availability, reservation overlap checking, polymorphic room pricing,
 * and cancellation deadlines.
 */
public class HotelBookingSystem {

    public static void main(String[] args) {
        HotelCustomer custA = new HotelCustomer("C1", "Customer A");
        HotelCustomer custB = new HotelCustomer("C2", "Customer B");
        HotelCustomer custC = new HotelCustomer("C3", "Customer C");

        StandardRoom room101 = new StandardRoom("101", 100.0);
        DeluxeRoom room201 = new DeluxeRoom("201", 200.0);

        room101.checkAvailability("Jan 1 to Jan 5", 1, 5);
        Reservation resA = room101.reserve(custA, "Jan 1-5", 1, 5, 4);

        room101.reserve(custB, "Jan 3 to Jan 7", 3, 7, 4);

        if (resA != null) {
            resA.cancel(true);
        }

        room201.reserve(custC, "Feb 10-12", 40, 42, 2);
    }
}

class HotelCustomer {
    private String id;
    private String name;

    public HotelCustomer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Room {
    protected String roomNumber;
    protected double ratePerNight;
    protected List<Reservation> reservations = new ArrayList<>();

    public Room(String roomNumber, double ratePerNight) {
        this.roomNumber = roomNumber;
        this.ratePerNight = ratePerNight;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public abstract String getCategoryName();

    public double calculatePrice(int nights) {
        return ratePerNight * nights;
    }

    public boolean isAvailable(int startDay, int endDay) {
        for (Reservation r : reservations) {
            if (r.isActive() && !(endDay <= r.getStartDay() || startDay >= r.getEndDay())) {
                return false;
            }
        }
        return true;
    }

    public void checkAvailability(String periodStr, int startDay, int endDay) {
        if (isAvailable(startDay, endDay)) {
            System.out.println(getCategoryName() + " " + roomNumber + " is available from " + periodStr + ".");
        } else {
            System.out.println(getCategoryName() + " " + roomNumber + " is not available from " + periodStr + ".");
        }
    }

    public Reservation reserve(HotelCustomer customer, String periodStr, int startDay, int endDay, int nights) {
        if (!isAvailable(startDay, endDay)) {
            System.out.println(getCategoryName() + " " + roomNumber + " is not available from " + periodStr + ".");
            return null;
        }

        double price = calculatePrice(nights);
        Reservation res = new Reservation(this, customer, periodStr, startDay, endDay, price);
        reservations.add(res);
        System.out.printf("Reservation confirmed for %s, %s %s (%s). Price: $%.2f.%n",
                customer.getName(), getCategoryName(), roomNumber, periodStr, price);
        return res;
    }
}

class StandardRoom extends Room {
    public StandardRoom(String roomNumber, double ratePerNight) {
        super(roomNumber, ratePerNight);
    }

    @Override
    public String getCategoryName() {
        return "Standard Room";
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomNumber, double ratePerNight) {
        super(roomNumber, ratePerNight);
    }

    @Override
    public String getCategoryName() {
        return "Deluxe Room";
    }
}

class Reservation {
    private Room room;
    private HotelCustomer customer;
    private String periodStr;
    private int startDay;
    private int endDay;
    private double price;
    private boolean active = true;

    public Reservation(Room room, HotelCustomer customer, String periodStr, int startDay, int endDay, double price) {
        this.room = room;
        this.customer = customer;
        this.periodStr = periodStr;
        this.startDay = startDay;
        this.endDay = endDay;
        this.price = price;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel(boolean beforeDeadline) {
        if (!active) return;
        if (beforeDeadline) {
            this.active = false;
            System.out.println("Reservation for " + customer.getName() + ", " + room.getCategoryName() + " " +
                    room.getRoomNumber() + " (" + periodStr + ") cancelled successfully.");
        } else {
            System.out.println("Cannot cancel reservation: cancellation deadline has passed.");
        }
    }
}
