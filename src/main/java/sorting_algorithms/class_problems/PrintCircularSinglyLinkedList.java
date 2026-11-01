package sorting_algorithms.class_problems;

/**
 * Problem 1: Print Circular Singly Linked List
 * 
 * Traverses a circular singly linked list and prints the data of each node
 * exactly once, separated by a space, followed by a newline.
 * Uses a do-while loop to terminate after one full cycle without relying on a null check.
 * Handles empty list by printing only a newline.
 * 
 * Time Complexity: O(n) where n is the number of nodes.
 * Space Complexity: O(1) auxiliary space.
 */
public class PrintCircularSinglyLinkedList {

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

    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node curr = head;
        StringBuilder sb = new StringBuilder();
        do {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(curr.data);
            curr = curr.next;
        } while (curr != head);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // Sample 1: head = 10 -> 20 -> 30 -> (back to 10)
        // Expected Output: 10 20 30
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        printCircular(n1);

        // Sample 2: head = null
        // Expected Output: (blank line)
        printCircular(null);
    }
}
