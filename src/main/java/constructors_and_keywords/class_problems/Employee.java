package constructors_and_keywords.class_problems;

/**
 * Problem M2: Payroll Batch Bonus Round
 * 
 * Uses the this keyword to resolve field and parameter naming collisions
 * in constructors and methods during batch salary increments.
 */
public class Employee {
    String empId;
    double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printFinalSalary() {
        System.out.println(this.empId + " | Final Salary: Rs " + this.salary);
    }

    public static void main(String[] args) {
        String[] empIds = {"E-101", "E-102", "E-103", "E-104"};
        double[] startingSalaries = {40000, 55000, 62000, 48000};
        double bonus = 5000;

        Employee[] staff = new Employee[empIds.length];
        for (int i = 0; i < empIds.length; i++) {
            staff[i] = new Employee(empIds[i], startingSalaries[i]);
            staff[i].raiseSalary(bonus);
            staff[i].printFinalSalary();
        }
    }
}
