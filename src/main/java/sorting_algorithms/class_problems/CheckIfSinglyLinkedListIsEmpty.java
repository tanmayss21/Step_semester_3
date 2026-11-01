package sorting_algorithms.class_problems;

/**
 * Problem 8: Check if Singly Linked List is Empty
 * 
 * Determines whether a singly linked list is empty by checking if the head reference is null.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class CheckIfSinglyLinkedListIsEmpty {

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

    public static boolean checkIfEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {
        // Sample 1: head = null
        // Expected Output: true
        System.out.println(checkIfEmpty(null));

        // Sample 2: head = 8
        // Expected Output: false
        Node sample2 = new Node(8);
        System.out.println(checkIfEmpty(sample2));
    }
}
