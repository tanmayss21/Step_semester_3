package object_oriented_design.assigment_problems;

/**
 * Question 2: The Assignment Submission Portal
 * 
 * Manages assignment submission workflows, polymorphic late penalty evaluation,
 * and immutable submission protection upon grading.
 */
public class AssignmentSubmissionPortal {

    public static void main(String[] args) {
        PortalStudent asha = new PortalStudent("Asha");
        PortalStudent ravi = new PortalStudent("Ravi");

        Assignment linkedListLab = new CodingAssignment("Linked List Lab", 50, 10);
        Assignment designEssay = new WrittenAssignment("Design Essay", 50, 12);

        Submission sub1 = asha.submit(linkedListLab, 10); // on time (due 10)
        Submission sub2 = ravi.submit(designEssay, 14);    // 2 days late (due 12)

        sub1.grade(45);
        sub2.grade(40);

        asha.submit(linkedListLab, 15);
    }
}

class PortalStudent {
    private String name;

    public PortalStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Submission submit(Assignment assignment, int submissionDate) {
        Submission existing = assignment.getSubmissionFor(this);
        if (existing != null && existing.isGraded()) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
            return existing;
        }

        int lateDays = Math.max(0, submissionDate - assignment.getDueDate());
        Submission sub = new Submission(this, assignment, submissionDate, lateDays);
        assignment.recordSubmission(sub);

        if (lateDays == 0) {
            System.out.println(name + "'s submission for '" + assignment.getTitle() + "' received (on time). Status: " + sub.getStatus() + ".");
        } else {
            System.out.println(name + "'s submission for '" + assignment.getTitle() + "' received (" + lateDays + " days late). Status: " + sub.getStatus() + ".");
        }
        return sub;
    }
}

abstract class Assignment {
    protected String title;
    protected int maxMarks;
    protected int dueDate;
    protected java.util.Map<PortalStudent, Submission> submissions = new java.util.HashMap<>();

    public Assignment(String title, int maxMarks, int dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void recordSubmission(Submission sub) {
        submissions.put(sub.getStudent(), sub);
    }

    public Submission getSubmissionFor(PortalStudent s) {
        return submissions.get(s);
    }

    public abstract double calculateLatePenaltyPercent(int lateDays);
}

class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, int dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double calculateLatePenaltyPercent(int lateDays) {
        return lateDays * 10.0;
    }
}

class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, int dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double calculateLatePenaltyPercent(int lateDays) {
        return lateDays * 20.0;
    }
}

class Submission {
    private PortalStudent student;
    private Assignment assignment;
    private int submissionDate;
    private int lateDays;
    private String status = "Submitted";
    private int finalMarks = 0;

    public Submission(PortalStudent student, Assignment assignment, int submissionDate, int lateDays) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.lateDays = lateDays;
    }

    public PortalStudent getStudent() {
        return student;
    }

    public String getStatus() {
        return status;
    }

    public boolean isGraded() {
        return "Graded".equals(status);
    }

    public void grade(int rawMarks) {
        this.status = "Graded";
        double penaltyPercent = assignment.calculateLatePenaltyPercent(lateDays);
        if (penaltyPercent > 0) {
            double penalty = rawMarks * (penaltyPercent / 100.0);
            this.finalMarks = (int) Math.round(rawMarks - penalty);
            System.out.printf("%s graded: %d/%d after %d%% late penalty. Status: Graded.%n",
                    student.getName(), finalMarks, assignment.getMaxMarks(), (int) penaltyPercent);
        } else {
            this.finalMarks = rawMarks;
            System.out.printf("%s graded: %d/%d. Status: Graded.%n",
                    student.getName(), finalMarks, assignment.getMaxMarks());
        }
    }
}
