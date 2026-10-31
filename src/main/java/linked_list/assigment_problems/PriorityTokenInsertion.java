package linked_list.assigment_problems;

import java.util.Scanner;

/**
 * Problem 1: Priority Token Insertion
 * 
 * Singly linked list operations:
 * - addFirst(token): O(1) time
 * - addLast(token): O(n) time (or O(1) with tail reference)
 * - insertAt(index, token): O(n) time (walk to index - 1)
 * Space complexity: O(1) auxiliary space per insertion
 */
public class PriorityTokenInsertion {

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

    private Node head;
    private int size;

    public PriorityTokenInsertion() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public int size() {
        return size;
    }

    /**
     * Inserts a token at the front of the list (Priority).
     * Time Complexity: O(1)
     */
    public void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Inserts a token at the end of the list (Normal).
     * Time Complexity: O(n)
     */
    public void addLast(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Inserts a token at the specified 0-based index (Rescheduled).
     * Time Complexity: O(n)
     */
    public void insertAt(int index, int token) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(token);
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        Node newNode = new Node(token);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    /**
     * Returns formatted representation: e.g. 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public void printList() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        if (args.length > 0 || System.console() == null && hasStandardInput()) {
            // Can read dynamic input if provided
        }

        // Default demonstration based on the assignment problem specification:
        // start = 101 -> 102 -> 103
        // addFirst(100), addLast(104), insertAt(2, 150)
        // Expected Output: 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null
        PriorityTokenInsertion tokenList = new PriorityTokenInsertion();
        tokenList.addLast(101);
        tokenList.addLast(102);
        tokenList.addLast(103);

        tokenList.addFirst(100);
        tokenList.addLast(104);
        tokenList.insertAt(2, 150);

        tokenList.printList();
    }

    private static boolean hasStandardInput() {
        try {
            return System.in.available() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
