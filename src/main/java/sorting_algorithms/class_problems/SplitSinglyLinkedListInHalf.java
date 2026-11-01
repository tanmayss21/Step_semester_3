package sorting_algorithms.class_problems;

/**
 * Problem 5: Split Singly Linked List into Two Halves
 * 
 * Splits a singly linked list into two halves using the fast and slow pointer technique.
 * If the list has an odd number of nodes, the first half contains the extra middle node.
 * Properly terminates the first half and returns the head of the second half.
 * 
 * Time Complexity: O(n) (one pass with fast pointer).
 * Space Complexity: O(1) auxiliary space (in-place split).
 */
public class SplitSinglyLinkedListInHalf {

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

    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) {
            return null; // single-node or empty list cannot form a second half
        }

        Node slow = head;
        Node fast = head;

        // When fast.next is null (odd count) or fast.next.next is null (even count),
        // slow is at the last node of the first half.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfHead = slow.next;
        slow.next = null; // terminate first half

        return secondHalfHead;
    }

    public static Node fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static String toListString(Node head) {
        if (head == null) {
            return "(empty list)";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            if (sb.length() > 0) {
                sb.append(" -> ");
            }
            sb.append(curr.data);
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample 1: head = 1 -> 2 -> 3 -> 4 -> 5
        // Expected Output: First half: 1 -> 2 -> 3 Returned: 4 -> 5
        Node sample1 = fromArray(new int[]{1, 2, 3, 4, 5});
        Node second1 = splitListInHalf(sample1);
        System.out.println("First half: " + toListString(sample1) + " Returned: " + toListString(second1));

        // Sample 2: head = 1 -> 2 -> 3 -> 4
        // Expected Output: First half: 1 -> 2 Returned: 3 -> 4
        Node sample2 = fromArray(new int[]{1, 2, 3, 4});
        Node second2 = splitListInHalf(sample2);
        System.out.println("First half: " + toListString(sample2) + " Returned: " + toListString(second2));
    }
}
