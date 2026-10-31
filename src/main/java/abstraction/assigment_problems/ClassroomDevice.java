package abstraction.assigment_problems;

/**
 * Problem 4: Digital Classroom Setup
 * 
 * Demonstrates combining abstract class extension with interface implementation
 * and compile-time method overloading.
 */
public abstract class ClassroomDevice {
    protected String assetTag;

    public ClassroomDevice(String assetTag) {
        this.assetTag = assetTag;
    }

    public abstract String operate();

    public static void main(String[] args) {
        Tablet t = new Tablet("TAB-5");
        System.out.println(t.operate());
        System.out.println(t.charge());
        System.out.println(t.charge(30));
    }
}

interface Chargeable {
    String charge();
    String charge(int minutes);
}

class Tablet extends ClassroomDevice implements Chargeable {
    public Tablet(String assetTag) {
        super(assetTag);
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}
