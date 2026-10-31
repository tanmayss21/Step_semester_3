package object_oriented_design.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 1: Vehicle Rental System
 * 
 * Implements a vehicle rental system with availability tracking,
 * polymorphic rental charge calculation, and vehicle return handling.
 */
public class VehicleRentalSystem {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Rental> activeRentals = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Rental rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getName() + " is currently unavailable.");
            return null;
        }

        double charge = vehicle.calculateRentalCharge(days);
        vehicle.setAvailable(false);
        Rental rental = new Rental(vehicle, customer, days, charge);
        activeRentals.add(rental);
        System.out.printf("%s rented successfully by %s. Rental charge: $%.2f.%n",
                vehicle.getName(), customer.getName(), charge);
        return rental;
    }

    public void returnVehicle(Vehicle vehicle, Customer customer) {
        Rental found = null;
        for (Rental r : activeRentals) {
            if (r.getVehicle().equals(vehicle) && r.getCustomer().equals(customer)) {
                found = r;
                break;
            }
        }

        if (found != null) {
            activeRentals.remove(found);
            vehicle.setAvailable(true);
            System.out.println(vehicle.getName() + " returned by " + customer.getName() + ".");
        }
    }

    public static void main(String[] args) {
        VehicleRentalSystem system = new VehicleRentalSystem();

        Customer c1 = new Customer("1", "Customer 1");
        Customer c2 = new Customer("2", "Customer 2");
        Customer c3 = new Customer("3", "Customer 3");

        Sedan sedanA = new Sedan("S1", "Sedan A", 50.0);
        SUV suvB = new SUV("V1", "SUV B", 80.0);

        system.addVehicle(sedanA);
        system.addVehicle(suvB);

        system.rentVehicle(sedanA, c1, 3);
        system.rentVehicle(sedanA, c2, 2);
        system.returnVehicle(sedanA, c1);
        system.rentVehicle(suvB, c3, 5);
    }
}

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

abstract class Vehicle {
    private String id;
    private String name;
    private boolean available = true;

    public Vehicle(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);
}

class Sedan extends Vehicle {
    private double dailyRate;

    public Sedan(String id, String name, double dailyRate) {
        super(id, name);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}

class SUV extends Vehicle {
    private double dailyRate;

    public SUV(String id, String name, double dailyRate) {
        super(id, name);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}

class Truck extends Vehicle {
    private double dailyRate;

    public Truck(String id, String name, double dailyRate) {
        super(id, name);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double charge;

    public Rental(Vehicle vehicle, Customer customer, int days, double charge) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.charge = charge;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getCharge() {
        return charge;
    }
}
