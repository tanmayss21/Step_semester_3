package string.assigment_problems;

public class ProductInventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        System.out.println("Input: \"Wireless Mouse,WM-2201,150\"");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.println("\nInput: \"Wireless Mouse,150\"");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
