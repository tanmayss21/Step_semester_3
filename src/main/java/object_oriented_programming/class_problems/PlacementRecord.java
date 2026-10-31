package object_oriented_programming.class_problems;

/**
 * Problem M1: From Parallel Arrays to a Class - Library Inventory / Student Placements
 * 
 * Replaces parallel arrays (names, companies, packages) with an OOP class
 * encapsulating placement data for individual students.
 */
public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(this.studentName + " -> " + this.company + " @ " + this.packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord[] studentRecords = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord record : studentRecords) {
            record.printRecord();
        }
    }
}
