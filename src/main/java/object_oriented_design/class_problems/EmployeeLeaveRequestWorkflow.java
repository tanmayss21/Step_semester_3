package object_oriented_design.class_problems;

/**
 * Question 2: Employee Leave Request Workflow
 * 
 * Manages employee leave submissions, review workflows with status transitions,
 * and guards against invalid status regressions.
 */
public class EmployeeLeaveRequestWorkflow {

    public static void main(String[] args) {
        FullTimeEmployee john = new FullTimeEmployee("E1", "John");
        PartTimeEmployee jane = new PartTimeEmployee("E2", "Jane");

        Manager alice = new Manager("M1", "Alice");
        Manager bob = new Manager("M2", "Bob");

        LeaveRequest req1 = john.submitLeaveRequest("Jan 1-5", 5);
        alice.reviewRequest(req1, true);

        LeaveRequest req2 = jane.submitLeaveRequest("Feb 10-11", 2);
        bob.reviewRequest(req2, false);

        req1.setStatus(LeaveStatus.PENDING);
    }
}

enum LeaveStatus {
    PENDING,
    APPROVED,
    REJECTED
}

abstract class Employee {
    private String id;
    private String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LeaveRequest submitLeaveRequest(String period, int days) {
        LeaveRequest request = new LeaveRequest(this, period, days);
        System.out.println("Leave request submitted for " + name + " (" + period + "). Status: " + request.getStatus() + ".");
        return request;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String id, String name) {
        super(id, name);
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String id, String name) {
        super(id, name);
    }
}

class Contractor extends Employee {
    public Contractor(String id, String name) {
        super(id, name);
    }
}

class Manager {
    private String id;
    private String name;

    public Manager(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void reviewRequest(LeaveRequest request, boolean approve) {
        if (approve) {
            request.approve();
            System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getPeriod() + ") approved. Status: " + request.getStatus() + ".");
        } else {
            request.reject();
            System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getPeriod() + ") rejected. Status: " + request.getStatus() + ".");
        }
    }
}

class LeaveRequest {
    private Employee employee;
    private String period;
    private int days;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, String period, int days) {
        this.employee = employee;
        this.period = period;
        this.days = days;
        this.status = LeaveStatus.PENDING;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getPeriod() {
        return period;
    }

    public int getDays() {
        return days;
    }

    public String getStatus() {
        if (status == LeaveStatus.PENDING) return "Pending";
        if (status == LeaveStatus.APPROVED) return "Approved";
        return "Rejected";
    }

    public void approve() {
        if (this.status == LeaveStatus.PENDING) {
            this.status = LeaveStatus.APPROVED;
        }
    }

    public void reject() {
        if (this.status == LeaveStatus.PENDING) {
            this.status = LeaveStatus.REJECTED;
        }
    }

    public void setStatus(LeaveStatus newStatus) {
        if (this.status != LeaveStatus.PENDING && newStatus == LeaveStatus.PENDING) {
            System.out.println("Cannot change leave request status from " + getStatus() + " to Pending.");
            return;
        }
        this.status = newStatus;
    }
}
