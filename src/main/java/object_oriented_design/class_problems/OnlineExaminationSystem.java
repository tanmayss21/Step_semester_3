package object_oriented_design.class_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question 3: Online Examination System
 * 
 * Manages question types, exam attempts, polymorphic question self-evaluation,
 * and immutable submission guards.
 */
public class OnlineExaminationSystem {

    public static void main(String[] args) {
        Student s1 = new Student("S1", "Student 1");

        Examination examA = new Examination("EX-A", "Exam A");
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("Q1", "Question 1", "C", 5);
        TrueFalseQuestion q2 = new TrueFalseQuestion("Q2", "Question 2", "False", 5);

        examA.addQuestion(q1);
        examA.addQuestion(q2);

        Attempt attempt = s1.startExam(examA);
        attempt.recordAnswer(q1, "C");
        attempt.recordAnswer(q2, "True");
        attempt.submit();

        attempt.recordAnswer(q1, "A");
    }
}

class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Attempt startExam(Examination exam) {
        System.out.println(exam.getTitle() + " started by " + name + ".");
        return new Attempt(this, exam);
    }
}

abstract class Question {
    protected String id;
    protected String prompt;
    protected int points;

    public Question(String id, String prompt, int points) {
        this.id = id;
        this.prompt = prompt;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    public MultipleChoiceQuestion(String id, String prompt, String correctAnswer, int points) {
        super(id, prompt, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    private String correctAnswer;

    public TrueFalseQuestion(String id, String prompt, String correctAnswer, int points) {
        super(id, prompt, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class Examination {
    private String id;
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Examination(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getTotalPossibleScore() {
        int sum = 0;
        for (Question q : questions) {
            sum += q.getPoints();
        }
        return sum;
    }
}

class Attempt {
    private Student student;
    private Examination examination;
    private Map<Question, String> recordedAnswers = new HashMap<>();
    private boolean submitted = false;

    public Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
    }

    public void recordAnswer(Question question, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        recordedAnswers.put(question, answer);
        System.out.println("Answer recorded for " + question.getPrompt() + ".");
    }

    public void submit() {
        this.submitted = true;
        int totalScore = 0;
        List<String> results = new ArrayList<>();

        for (Question q : examination.getQuestions()) {
            String ans = recordedAnswers.get(q);
            boolean correct = ans != null && q.evaluate(ans);
            int score = correct ? q.getPoints() : 0;
            totalScore += score;
            results.add(q.getPrompt() + ": " + (correct ? "Correct" : "Incorrect") + " (" + score + " points)");
        }

        System.out.println(examination.getTitle() + " submitted by " + student.getName() +
                ". Result: " + String.join(", ", results) + ". Total score: " + totalScore + "/" + examination.getTotalPossibleScore() + ".");
    }
}
