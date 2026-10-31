package object_oriented_design.assigment_problems;

/**
 * Question 1: The Hostel Laundry Queue
 * 
 * Models a hostel washing machine booking system with wash type abstractions,
 * busy/free status protection, and cycle completion workflows.
 */
public class HostelLaundryQueue {

    public static void main(String[] args) {
        LaundryStudent asha = new LaundryStudent("Asha");
        LaundryStudent ravi = new LaundryStudent("Ravi");
        LaundryStudent neha = new LaundryStudent("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        WashType quick = new QuickWash();
        WashType normal = new NormalWash();
        WashType heavy = new HeavyWash();

        m1.startWash(asha, quick);
        m1.startWash(ravi, heavy);
        m2.startWash(ravi, heavy);
        m1.completeWash();
        m1.startWash(neha, normal);
    }
}

class LaundryStudent {
    private String name;

    public LaundryStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface WashType {
    String getName();
    int getDurationMinutes();
    double getCharge();
}

class QuickWash implements WashType {
    @Override
    public String getName() { return "Quick"; }
    @Override
    public int getDurationMinutes() { return 30; }
    @Override
    public double getCharge() { return 20.0; }
}

class NormalWash implements WashType {
    @Override
    public String getName() { return "Normal"; }
    @Override
    public int getDurationMinutes() { return 45; }
    @Override
    public double getCharge() { return 30.0; }
}

class HeavyWash implements WashType {
    @Override
    public String getName() { return "Heavy"; }
    @Override
    public int getDurationMinutes() { return 60; }
    @Override
    public double getCharge() { return 45.0; }
}

class WashingMachine {
    private String machineId;
    private boolean busy = false;
    private WashCycle currentCycle = null;

    public WashingMachine(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isBusy() {
        return busy;
    }

    public boolean startWash(LaundryStudent student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return false;
        }

        this.busy = true;
        this.currentCycle = new WashCycle(this, student, washType);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                washType.getName(), machineId, student.getName(), washType.getDurationMinutes(), washType.getCharge());
        return true;
    }

    public void completeWash() {
        if (busy) {
            this.busy = false;
            this.currentCycle = null;
            System.out.println(machineId + " cycle completed. " + machineId + " is now free.");
        }
    }
}

class WashCycle {
    private WashingMachine machine;
    private LaundryStudent student;
    private WashType washType;

    public WashCycle(WashingMachine machine, LaundryStudent student, WashType washType) {
        this.machine = machine;
        this.student = student;
        this.washType = washType;
    }
}
