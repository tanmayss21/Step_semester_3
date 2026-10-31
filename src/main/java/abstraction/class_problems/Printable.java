package abstraction.class_problems;

/**
 * Problem 2: Warehouse Label Printer
 * 
 * Demonstrates common interface implementation across unrelated classes
 * and polymorphic array processing.
 */
public interface Printable {
    String printLabel();

    static void printAll(Printable[] items) {
        if (items != null) {
            for (Printable item : items) {
                if (item != null) {
                    System.out.println(item.printLabel());
                }
            }
        }
    }

    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        System.out.println(p.printLabel());

        Invoice i = new Invoice("INV-42");
        System.out.println(i.printLabel());

        printAll(new Printable[]{ p, i });
    }
}

class PackageBox implements Printable {
    private String trackingId;

    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}

class Invoice implements Printable {
    private String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}
