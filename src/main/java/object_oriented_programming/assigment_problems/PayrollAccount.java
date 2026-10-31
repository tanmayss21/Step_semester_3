package object_oriented_programming.assigment_problems;

/**
 * Problem M2: Encapsulated Payroll Account
 * 
 * Provides encapsulation with private fields for basicSalary and bonus,
 * validated bonus credits, validated percentage tax deductions,
 * and read-only access to net salary.
 */
public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double initialSalary) {
        if (initialSalary < 0.0) {
            System.out.println("Warning: Opening basic salary cannot be negative. Setting salary to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = initialSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0.0) {
            System.out.println("Credit rejected: bonus amount must be greater than 0");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0.0 || percent > 100.0) {
            System.out.println("Tax deduction rejected: percentage must be between 0 and 100");
            return;
        }
        this.basicSalary -= (this.basicSalary * percent / 100.0);
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        PayrollAccount employeeAccount = new PayrollAccount(50000);
        employeeAccount.creditBonus(5000);
        employeeAccount.deductTax(10);
        System.out.println("Net salary: Rs " + employeeAccount.getNetSalary());
    }
}
