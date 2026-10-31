package constructors_and_keywords.assigment_problems;

/**
 * Problem A1: Overloaded Constructors for Hackathon Registration
 * 
 * Demonstrates constructor overloading and this(...) constructor chaining
 * to assign fallback values for unassigned team registrations.
 */
public class Participant {
    String name;
    String teamName;
    boolean registered;

    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(this.name + " | " + this.teamName + " | Registered: " + this.registered);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        for (int i = 0; i < names.length; i++) {
            Participant participant;
            if (teamNames[i] == null || teamNames[i].trim().isEmpty()) {
                participant = new Participant(names[i]);
            } else {
                participant = new Participant(names[i], teamNames[i]);
            }
            participant.printStatus();
        }
    }
}
