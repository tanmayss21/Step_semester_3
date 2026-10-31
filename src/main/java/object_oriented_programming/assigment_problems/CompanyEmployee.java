package object_oriented_programming.assigment_problems;

public class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyEmployee("Amit", 50000);
        new CompanyEmployee("Pooja", 55000);
        new CompanyEmployee("Sneha", 60000);

        CompanyEmployee.printCompanyInfo();
    }
}
