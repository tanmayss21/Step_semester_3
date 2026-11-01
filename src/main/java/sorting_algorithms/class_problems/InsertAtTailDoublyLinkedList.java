package sorting_algorithms.class_problems;

/**
 * Problem 2: Insert at Tail of Doubly Linked List (from Head)
 * 
 * Inserts a new node with the given value at the tail of a doubly linked list
 * when only the head reference is initially available. Correctly sets all prev and next pointers.
 * 
 * Time Complexity: O(n) to traverse to the tail node (O(1) if head is null).
 * Space Complexity: O(1) auxiliary space.
 */
public class InsertAtTailDoublyLinkedList {

    public static class DNode {
        public int data;
        public DNode prev;
        public DNode next;

        public DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) {
            return newNode;
        }

        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static String toListString(DNode head) {
        if (head == null) {
            return "(empty list)";
        }
        StringBuilder sb = new StringBuilder();
        DNode curr = head;
        while (curr != null) {
            if (sb.length() > 0) {
                sb.append(" <-> ");
            }
            sb.append(curr.data);
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample 1: head = 1 <-> 2 <-> 3, value = 4
        // Expected Output: 1 <-> 2 <-> 3 <-> 4
        DNode d1 = new DNode(1);
        DNode d2 = new DNode(2);
        DNode d3 = new DNode(3);
        d1.next = d2; d2.prev = d1;
        d2.next = d3; d3.prev = d2;

        DNode res1 = insertAtTailDoubly(d1, 4);
        System.out.println(toListString(res1));

        // Sample 2: head = null, value = 7
        // Expected Output: 7
        DNode res2 = insertAtTailDoubly(null, 7);
        System.out.println(toListString(res2));
    }
}
