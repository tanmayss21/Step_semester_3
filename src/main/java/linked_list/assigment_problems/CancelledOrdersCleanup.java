package linked_list.assigment_problems;

/**
 * Problem 2: Cancelled Orders Cleanup
 * 
 * Implement Node removeAll(Node head, int code) that removes every node
 * with the given value and returns the (possibly new) head.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the list.
 * Space Complexity: O(1) auxiliary space (in-place modification).
 */
public class CancelledOrdersCleanup {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Removes all nodes having the specified code from the singly linked list.
     * 
     * @param head head of the singly linked list
     * @param code value to be removed
     * @return new head of the modified list
     */
    public static Node removeAll(Node head, int code) {
        // Step 1: Remove matching nodes from the front by advancing head
        while (head != null && head.data == code) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        // Step 2: Walk with a previous reference and skip matching nodes
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.data == code) {
                prev.next = curr.next; // skip current node
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }

    /**
     * Helper to create a linked list from an array of integers.
     */
    public static Node fromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * Formats the list to string representation: "3 -> 8 -> null" or "null".
     */
    public static String toListString(Node head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample 1: orders = 5 -> 3 -> 5 -> 8 -> 5, code = 5
        // Expected Output: 3 -> 8 -> null
        Node sample1 = fromArray(new int[]{5, 3, 5, 8, 5});
        sample1 = removeAll(sample1, 5);
        System.out.println(toListString(sample1));

        // Sample 2: orders = 5 -> 5 -> 5, code = 5
        // Expected Output: null
        Node sample2 = fromArray(new int[]{5, 5, 5});
        sample2 = removeAll(sample2, 5);
        System.out.println(toListString(sample2));
    }
}
