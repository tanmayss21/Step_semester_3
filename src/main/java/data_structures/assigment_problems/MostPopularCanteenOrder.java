package data_structures.assigment_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3: Most Popular Canteen Order
 * 
 * Determines the most frequently ordered canteen item using hash-based counting
 * with tie-breaking based on first occurrence in O(n) time and O(unique) space.
 */
public class MostPopularCanteenOrder {

    public static class PopularItemResult {
        public final String item;
        public final int count;

        public PopularItemResult(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static PopularItemResult mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new PopularItemResult("", 0);
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String order : orders) {
            if (order != null) {
                counts.put(order, counts.getOrDefault(order, 0) + 1);
            }
        }

        String bestItem = "";
        int maxCount = 0;

        for (String order : orders) {
            if (order != null) {
                int count = counts.get(order);
                if (count > maxCount) {
                    maxCount = count;
                    bestItem = order;
                }
            }
        }

        return new PopularItemResult(bestItem, maxCount);
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(orders1)); // ("dosa", 3)

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(orders2)); // ("tea", 2)
    }
}
