package sorting_algorithms.class_problems;

/**
 * Problem 6: Reverse First K Nodes of Singly Linked List
 * 
 * Reverses the links for only the first k nodes of a singly linked list.
 * Connects the tail of the reversed prefix (the original head) to the (k+1)-th node.
 * 
 * Time Complexity: O(k) operations.
 * Space Complexity: O(1) auxiliary space (in-place link reversal).
 */
public class ReverseFirstKNodesSinglyLinkedList {

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

    public static Node reverseFirstKNodes(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = null;

        // Reverse first k nodes
        for (int i = 0; i < k && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Original head is now the end of the reversed portion.
        // Connect it to the (k+1)-th node (which is currently stored in curr).
        head.next = curr;

        return prev; // new head of the whole list
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
        // Sample 1: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
        // Expected Output: 3 -> 2 -> 1 -> 4 -> 5
        Node sample1 = fromArray(new int[]{1, 2, 3, 4, 5});
        sample1 = reverseFirstKNodes(sample1, 3);
        System.out.println(toListString(sample1));

        // Sample 2: head = 1 -> 2 -> 3 -> 4 -> 5, k = 5
        // Expected Output: 5 -> 4 -> 3 -> 2 -> 1
        Node sample2 = fromArray(new int[]{1, 2, 3, 4, 5});
        sample2 = reverseFirstKNodes(sample2, 5);
        System.out.println(toListString(sample2));
    }
}
