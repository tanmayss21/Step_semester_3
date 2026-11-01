package sorting_algorithms.class_problems;

/**
 * Problem 9: Insert at End of Circular Singly Linked List
 * 
 * Inserts a new node with the specified value at the logical end of a circular singly linked list.
 * The new node's next pointer is set to head, and the previous last node's next is updated to newNode.
 * 
 * Time Complexity: O(n) to traverse from head to the current last node (O(1) if head is null).
 * Space Complexity: O(1) auxiliary space.
 */
public class InsertAtEndCircularSinglyLinkedList {

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

    public static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Find the node whose next points to head
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;

        return head;
    }

    public static String toCircularString(Node head) {
        if (head == null) {
            return "(empty list)";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        do {
            if (sb.length() > 0) {
                sb.append(" -> ");
            }
            sb.append(curr.data);
            curr = curr.next;
        } while (curr != head);

        sb.append(" -> (back to ").append(head.data).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample 1: head = 1 -> 2 -> 3 -> (back to 1), value = 4
        // Expected Output: 1 -> 2 -> 3 -> 4 -> (back to 1)
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        Node res1 = insertAtEndCircular(n1, 4);
        System.out.println(toCircularString(res1));

        // Sample 2: head = null, value = 9
        // Expected Output: 9 -> (back to 9)
        Node res2 = insertAtEndCircular(null, 9);
        System.out.println(toCircularString(res2));
    }
}
