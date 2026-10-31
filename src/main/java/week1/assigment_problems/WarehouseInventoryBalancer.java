package week1.assigment_problems;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid inventory records.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "Section A";
        int highestItemNumber = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1; // 1-based index (e.g., Item 3)
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1; // 1-based index
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                " | Status: " + status + " | Highest Quantity: " + highestQuantity +
                " (" + highestSection + ", Item " + highestItemNumber + ")");
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Balancer ===\n");

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
