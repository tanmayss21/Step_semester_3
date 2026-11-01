package sorting_algorithms.class_problems;

/**
 * Problem 4: Delete N-th Node from Singly Linked List
 * 
 * Deletes the node at the 1-based position n and returns the head of the modified list.
 * 
 * Time Complexity: O(n) time where n is the 1-based index (O(1) when n = 1).
 * Space Complexity: O(1) auxiliary space.
 */
public class DeleteNthNodeSinglyLinkedList {

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

    public static Node deleteNthNode(Node head, int n) {
        if (head == null || n < 1) {
            return head;
        }

        // Special case: deleting head
        if (n == 1) {
            return head.next;
        }

        // Traverse to (n-1)-th node
        Node curr = head;
        for (int i = 1; i < n - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
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
        // Sample 1: head = 10 -> 20 -> 30 -> 40, n = 3
        // Expected Output: 10 -> 20 -> 40
        Node sample1 = fromArray(new int[]{10, 20, 30, 40});
        sample1 = deleteNthNode(sample1, 3);
        System.out.println(toListString(sample1));

        // Sample 2: head = 10 -> 20 -> 30 -> 40, n = 1
        // Expected Output: 20 -> 30 -> 40
        Node sample2 = fromArray(new int[]{10, 20, 30, 40});
        sample2 = deleteNthNode(sample2, 1);
        System.out.println(toListString(sample2));
    }
}
