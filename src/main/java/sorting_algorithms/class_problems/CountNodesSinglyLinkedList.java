package sorting_algorithms.class_problems;

/**
 * Problem 7: Count Nodes in Singly Linked List
 * 
 * Traverses a singly linked list from head to tail and returns the total node count.
 * Returns 0 if the list is empty (head == null).
 * 
 * Time Complexity: O(n) where n is the number of nodes.
 * Space Complexity: O(1) auxiliary space.
 */
public class CountNodesSinglyLinkedList {

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

    public static int countNodes(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
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

    public static void main(String[] args) {
        // Sample 1: head = 5 -> 10 -> 15
        // Expected Output: 3
        Node sample1 = fromArray(new int[]{5, 10, 15});
        System.out.println(countNodes(sample1));

        // Sample 2: head = null
        // Expected Output: 0
        System.out.println(countNodes(null));
    }
}
