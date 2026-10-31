package linked_list.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 5: Payroll Register System
 * 
 * Implements a polymorphic payroll processing system for FullTime, PartTime, and Intern staff.
 * Stores payslips in an array, prints each payslip, and computes total payout and top earner.
 */
public class PayrollRegisterSystem {

    public static abstract class Staff {
        protected String name;
        protected String type;

        public Staff(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public abstract long calculatePay();

        public String getPayslip() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
        }
    }

    public static class FullTimeStaff extends Staff {
        private final long salary;

        public FullTimeStaff(String name, long salary) {
            super(name, "FullTime");
            this.salary = salary;
        }

        @Override
        public long calculatePay() {
            return salary;
        }
    }

    public static class PartTimeStaff extends Staff {
        private final long hours;
        private final long rate;

        public PartTimeStaff(String name, long hours, long rate) {
            super(name, "PartTime");
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public long calculatePay() {
            return hours * rate;
        }
    }

    public static class InternStaff extends Staff {
        private final long stipend;

        public InternStaff(String name, long stipend) {
            super(name, "Intern");
            this.stipend = stipend;
        }

        @Override
        public long calculatePay() {
            return stipend;
        }
    }

    private final List<Staff> staffList = new ArrayList<>();

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void generatePayrollReport() {
        if (staffList.isEmpty()) {
            return;
        }

        long totalPay = 0;
        Staff topEarner = staffList.get(0);

        for (Staff staff : staffList) {
            System.out.println(staff.getPayslip());
            long pay = staff.calculatePay();
            totalPay += pay;
            if (pay > topEarner.calculatePay()) {
                topEarner = staff;
            }
        }

        System.out.println("Total " + totalPay);
        System.out.println("top earner " + topEarner.getName());
    }

    public static Staff parseStaff(String line) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }
        String[] parts = line.trim().split("\\s+");
        String type = parts[0];
        String name = parts[1];

        if ("FullTime".equalsIgnoreCase(type)) {
            long salary = Long.parseLong(parts[2]);
            return new FullTimeStaff(name, salary);
        } else if ("PartTime".equalsIgnoreCase(type)) {
            long hours = Long.parseLong(parts[2]);
            long rate = Long.parseLong(parts[3]);
            return new PartTimeStaff(name, hours, rate);
        } else if ("Intern".equalsIgnoreCase(type)) {
            long stipend = Long.parseLong(parts[2]);
            return new InternStaff(name, stipend);
        }
        return null;
    }

    public static void main(String[] args) {
        PayrollRegisterSystem register = new PayrollRegisterSystem();

        try {
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    Staff staff = parseStaff(line);
                    if (staff != null) {
                        register.addStaff(staff);
                    }
                }
                scanner.close();
            }
        } catch (Exception ignored) {}

        if (register.staffList.isEmpty()) {
            // Default sample execution
            register.addStaff(new FullTimeStaff("Asha", 50000));
            register.addStaff(new PartTimeStaff("Ravi", 80, 300));
            register.addStaff(new InternStaff("Neha", 15000));
        }

        register.generatePayrollReport();
    }
}
