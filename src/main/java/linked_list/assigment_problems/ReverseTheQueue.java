package linked_list.assigment_problems;

/**
 * Problem 3: Reverse the Queue
 * 
 * Reverses a singly linked list in-place without creating any new nodes.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the list.
 * Space Complexity: O(1) auxiliary space using 3 pointers (prev, curr, next).
 */
public class ReverseTheQueue {

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
     * Reverses the singly linked list in place and returns the new head.
     * 
     * @param head head of the original list
     * @return new head of the reversed list
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next; // store next node
            curr.next = prev; // reverse pointer
            prev = curr;      // move prev forward
            curr = next;      // move curr forward
        }

        return prev; // new head
    }

    /**
     * Helper to construct linked list from array.
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
     * Formats the list to string representation: "4 -> 3 -> 2 -> 1 -> null"
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
        // Sample 1: queue = 1 -> 2 -> 3 -> 4
        // Expected Output: 4 -> 3 -> 2 -> 1 -> null
        Node sample1 = fromArray(new int[]{1, 2, 3, 4});
        sample1 = reverse(sample1);
        System.out.println(toListString(sample1));

        // Sample 2: queue = 9
        // Expected Output: 9 -> null
        Node sample2 = fromArray(new int[]{9});
        sample2 = reverse(sample2);
        System.out.println(toListString(sample2));
    }
}
