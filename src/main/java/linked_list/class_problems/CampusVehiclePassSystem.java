package linked_list.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem 2: Campus Vehicle Pass System
 * 
 * Manages campus vehicle registration, fee computation, and electric charging bay allocation.
 * Uses inheritance hierarchy and a Chargeable interface for electric vehicles.
 */
public class CampusVehiclePassSystem {

    public interface Chargeable {
        boolean canCharge();
    }

    public static abstract class Vehicle {
        protected String passNumber;
        protected String ownerName;
        protected String typeName;

        public Vehicle(String passNumber, String ownerName, String typeName) {
            this.passNumber = passNumber;
            this.ownerName = ownerName;
            this.typeName = typeName;
        }

        public String getPassNumber() {
            return passNumber;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public String getTypeName() {
            return typeName;
        }

        public abstract int getPassFee();
    }

    public static class Bike extends Vehicle {
        public Bike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Bike");
        }

        @Override
        public int getPassFee() {
            return 300;
        }
    }

    public static class Car extends Vehicle {
        public Car(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Car");
        }

        @Override
        public int getPassFee() {
            return 1000;
        }
    }

    public static class EBike extends Vehicle implements Chargeable {
        public EBike(String passNumber, String ownerName, String typeName) {
            super(passNumber, ownerName, typeName);
        }

        @Override
        public int getPassFee() {
            return 300;
        }

        @Override
        public boolean canCharge() {
            return true;
        }
    }

    public static class ECar extends Vehicle implements Chargeable {
        public ECar(String passNumber, String ownerName, String typeName) {
            super(passNumber, ownerName, typeName);
        }

        @Override
        public int getPassFee() {
            return 1000;
        }

        @Override
        public boolean canCharge() {
            return true;
        }
    }

    private final Map<String, Vehicle> vehicles = new HashMap<>();

    public static Vehicle createVehicle(String type, String passNumber, String ownerName) {
        String normalized = type.replace("-", "").toUpperCase();
        if (normalized.equals("BIKE")) {
            return new Bike(passNumber, ownerName);
        } else if (normalized.equals("CAR")) {
            return new Car(passNumber, ownerName);
        } else if (normalized.equals("EBIKE")) {
            return new EBike(passNumber, ownerName, type);
        } else if (normalized.equals("ECAR")) {
            return new ECar(passNumber, ownerName, type);
        }
        throw new IllegalArgumentException("Unknown vehicle type: " + type);
    }

    public void registerPass(String type, String passNumber, String ownerName) {
        Vehicle v = createVehicle(type, passNumber, ownerName);
        vehicles.put(passNumber, v);
        System.out.println(v.getPassNumber() + " (" + v.getTypeName() + ") pass fee " + v.getPassFee());
    }

    public void bookChargingBay(String passNumber) {
        Vehicle v = vehicles.get(passNumber);
        if (v == null) {
            System.out.println(passNumber + " not found");
        } else if (v instanceof Chargeable) {
            System.out.println(passNumber + " charging bay allotted");
        } else {
            System.out.println(passNumber + " rejected: charging unsupported");
        }
    }

    public void processCommand(String line) {
        if (line == null || line.trim().isEmpty()) {
            return;
        }
        String[] parts = line.trim().split("\\s+");
        String command = parts[0].toUpperCase();

        if (command.equals("PASS")) {
            String type = parts[1];
            String passNumber = parts[2];
            String ownerName = parts.length > 3 ? parts[3] : "";
            registerPass(type, passNumber, ownerName);
        } else if (command.equals("CHARGE")) {
            String passNumber = parts[1];
            bookChargingBay(passNumber);
        }
    }

    public static void main(String[] args) {
        CampusVehiclePassSystem system = new CampusVehiclePassSystem();

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        system.processCommand(line);
                    }
                }
                scanner.close();
                return;
            }
        } catch (Exception ignored) {}

        // Default sample execution
        String[] sampleOperations = {
            "PASS Bike KA01 Asha",
            "PASS ECar KA02 Ravi",
            "CHARGE KA02",
            "CHARGE KA01"
        };
        for (String op : sampleOperations) {
            system.processCommand(op);
        }
    }
}
