package linked_list.assigment_problems;

/**
 * Problem 4: Train Coaches Both Ways
 * 
 * Doubly linked list representation of train coaches.
 * Supports:
 * - addLast(name): O(1) time with tail reference
 * - remove(name): O(n) finding coach, O(1) unlinking
 * - printForward(): O(n) traversal
 * - printBackward(): O(n) traversal
 * Space Complexity: O(1) auxiliary space
 */
public class TrainCoachesBothWays {

    public static class DNode {
        public String name;
        public DNode prev;
        public DNode next;

        public DNode(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    private DNode head;
    private DNode tail;
    private int size;

    public TrainCoachesBothWays() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DNode getHead() {
        return head;
    }

    public DNode getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    /**
     * Appends a coach to the end of the train.
     * Time Complexity: O(1) with tail reference.
     */
    public void addLast(String name) {
        DNode newNode = new DNode(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes the first coach matching the specified name.
     * Time Complexity: O(n) to find, O(1) to unlink.
     */
    public boolean remove(String name) {
        if (head == null || name == null) {
            return false;
        }

        DNode curr = head;
        while (curr != null) {
            if (name.equals(curr.name)) {
                // Coach found, unlink curr
                if (curr == head && curr == tail) {
                    // Only one node in list
                    head = null;
                    tail = null;
                } else if (curr == head) {
                    // Removing head node
                    head = head.next;
                    head.prev = null;
                } else if (curr == tail) {
                    // Removing tail node
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    // Internal node
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * Prints coaches from engine (head) to guard (tail).
     * Format: Forward: Engine <-> A1 <-> B2 <-> Guard
     */
    public void printForward() {
        System.out.println(getForwardString());
    }

    public String getForwardString() {
        StringBuilder sb = new StringBuilder("Forward: ");
        DNode curr = head;
        boolean first = true;
        while (curr != null) {
            if (!first) {
                sb.append(" <-> ");
            }
            sb.append(curr.name);
            first = false;
            curr = curr.next;
        }
        return sb.toString();
    }

    /**
     * Prints coaches from guard (tail) to engine (head).
     * Format: Backward: Guard <-> B2 <-> A1 <-> Engine
     */
    public void printBackward() {
        System.out.println(getBackwardString());
    }

    public String getBackwardString() {
        StringBuilder sb = new StringBuilder("Backward: ");
        DNode curr = tail;
        boolean first = true;
        while (curr != null) {
            if (!first) {
                sb.append(" <-> ");
            }
            sb.append(curr.name);
            first = false;
            curr = curr.prev;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example: coaches = Engine, A1, B1, B2, Guard; remove B1
        // Expected Output:
        // Forward: Engine <-> A1 <-> B2 <-> Guard
        // Backward: Guard <-> B2 <-> A1 <-> Engine
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
