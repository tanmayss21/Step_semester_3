package sorting_algorithms.class_problems;

/**
 * Problem 10: Delete Last Node from Doubly Linked List (from Head)
 * 
 * Removes the final node from a doubly linked list when only the head reference is available.
 * Handles empty list, single-node list, and multi-node list with correct pointer updates.
 * 
 * Time Complexity: O(n) to traverse to the end of the list (O(1) if head is null or single node).
 * Space Complexity: O(1) auxiliary space.
 */
public class DeleteLastNodeDoublyLinkedList {

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

    public static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null || head.next == null) {
            return null; // list becomes empty
        }

        // Traverse to second-to-last node
        DNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        // Detach the last node
        curr.next.prev = null;
        curr.next = null;

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
        // Sample 1: head = 1 <-> 2 <-> 3
        // Expected Output: 1 <-> 2
        DNode d1 = new DNode(1);
        DNode d2 = new DNode(2);
        DNode d3 = new DNode(3);
        d1.next = d2; d2.prev = d1;
        d2.next = d3; d3.prev = d2;

        DNode res1 = deleteLastNodeDoubly(d1);
        System.out.println(toListString(res1));

        // Sample 2: head = 5
        // Expected Output: (empty list)
        DNode dSingle = new DNode(5);
        DNode res2 = deleteLastNodeDoubly(dSingle);
        System.out.println(toListString(res2));
    }
}
