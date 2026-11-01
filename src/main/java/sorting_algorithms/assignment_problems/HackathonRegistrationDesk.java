package sorting_algorithms.assignment_problems;

/**
 * Problem 2: The Hackathon Registration Desk
 * 
 * Orders teams by size (smallest first) using Insertion Sort.
 * Guarantees stability by shifting earlier teams right only when their size
 * is strictly greater than the key team's size.
 * 
 * Time Complexity:
 * - Best Case: O(n) when teams are already sorted by size.
 * - Worst / Average Case: O(n^2) when teams are in reverse order or arbitrary order.
 * Extra Space Complexity: O(1) auxiliary space (in-place).
 * Stability: Stable (using strictly greater '>' ensures teams of equal size maintain registration order).
 */
public class HackathonRegistrationDesk {

    public static class Team {
        public String name;
        public int size;

        public Team(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return name + "(" + size + ")";
        }
    }

    /**
     * Sorts teams in-place by size in ascending order using Insertion Sort.
     * Preserves original registration order for equal-sized teams.
     */
    public static void sortTeams(Team[] teams) {
        if (teams == null || teams.length <= 1) {
            return;
        }

        for (int i = 1; i < teams.length; i++) {
            Team key = teams[i];
            int j = i - 1;

            // Shift strictly larger elements to the right
            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = key;
        }
    }

    public static String formatTeams(Team[] teams) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(teams[i].toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Input: Pixel(4), Byte(2), Nova(4), Echo(3), Atom(2)
        // Expected Output: Byte(2), Atom(2), Echo(3), Pixel(4), Nova(4)
        Team[] teams = {
            new Team("Pixel", 4),
            new Team("Byte", 2),
            new Team("Nova", 4),
            new Team("Echo", 3),
            new Team("Atom", 2)
        };

        sortTeams(teams);
        System.out.println(formatTeams(teams));
    }
}
