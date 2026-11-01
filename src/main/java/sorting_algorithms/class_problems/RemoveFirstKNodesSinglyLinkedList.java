package sorting_algorithms.class_problems;

/**
 * Problem 3: Remove First K Nodes from Singly Linked List
 * 
 * Advances the head pointer k times to remove the first k nodes.
 * If k is greater than or equal to the total list length, returns null (empty list).
 * 
 * Time Complexity: O(min(k, n)) time.
 * Space Complexity: O(1) auxiliary space.
 */
public class RemoveFirstKNodesSinglyLinkedList {

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

    public static Node removeFirstKNodes(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        Node curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return null;
            }
            curr = curr.next;
        }

        return curr;
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
        // Sample 1: head = 1 -> 2 -> 3 -> 4 -> 5, k = 2
        // Expected Output: 3 -> 4 -> 5
        Node sample1 = fromArray(new int[]{1, 2, 3, 4, 5});
        sample1 = removeFirstKNodes(sample1, 2);
        System.out.println(toListString(sample1));

        // Sample 2: head = 1 -> 2, k = 5
        // Expected Output: (empty list)
        Node sample2 = fromArray(new int[]{1, 2});
        sample2 = removeFirstKNodes(sample2, 5);
        System.out.println(toListString(sample2));
    }
}
