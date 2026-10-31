package object_oriented_programming.assigment_problems;

/**
 * Problem M3: Overloaded Constructors for an Employee
 * 
 * Implements constructor overloading and this(...) chaining to support
 * both permanent employees and newly joined interns without code duplication.
 */
public class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(this.empId + " | " + this.empName + " | Rs " + this.salary + " | Intern: " + this.isIntern);
    }

    public static void main(String[] args) {
        EmployeeProfile permanent = new EmployeeProfile("E-101", "Divya", 65000);
        EmployeeProfile intern = new EmployeeProfile("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
