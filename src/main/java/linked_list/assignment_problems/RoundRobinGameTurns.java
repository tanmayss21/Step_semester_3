package linked_list.assignment_problems;

/**
 * Problem 5: Round-Robin Game Turns
 * 
 * Circular singly linked list representing players in a game turn circle.
 * In a circular list, tail.next points to the head.
 * 
 * Time Complexity:
 * - addLast(name): O(1) with tail reference
 * - printTurns(turns): O(k) where k is the number of turns
 * Space Complexity: O(1) auxiliary space
 */
public class RoundRobinGameTurns {

    public static class Node {
        public String name;
        public Node next;

        public Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    private Node tail;
    private int size;

    public RoundRobinGameTurns() {
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * Appends a player to the circular singly linked list.
     * Time Complexity: O(1)
     */
    public void addLast(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the sequence of players for the given number of turns.
     * Starts from head (tail.next).
     */
    public String getTurnsString(int turns) {
        if (tail == null || turns <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = tail.next;
        for (int i = 0; i < turns; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(curr.name);
            curr = curr.next;
        }
        return sb.toString();
    }

    /**
     * Prints the player for each turn in order, space separated.
     * Format: Asha Ravi Neha Asha Ravi Neha Asha
     */
    public void printTurns(int turns) {
        System.out.println(getTurnsString(turns));
    }

    public static void main(String[] args) {
        RoundRobinGameTurns game = new RoundRobinGameTurns();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        game.printTurns(7);
    }
}
