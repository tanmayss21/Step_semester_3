package constructors_and_keywords.assigment_problems;

/**
 * Problem A2: this Keyword for Canteen Inventory - Batch Restock
 * 
 * Demonstrates resolving field and parameter naming conflicts in constructors
 * and methods using the this keyword.
 */
public class Item {
    String itemName;
    int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public void printStock() {
        System.out.println(this.itemName + " | Final Stock: " + this.stock);
    }

    public static void main(String[] args) {
        Item[] inventory = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        int restockAmount = 20;

        for (Item item : inventory) {
            item.restock(restockAmount);
            item.printStock();
        }
    }
}
