package string.class_problems;

public class CSVStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        System.out.println("Input 1: \"Ananya Verma,RA2211003010123,CSE\"");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        System.out.println("\nInput 2: \"Ananya Verma,CSE\"");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
