package object_oriented_design.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question 5: The Campus Notice Broadcaster
 * 
 * Implements notice board broadcasts with target department filtering,
 * notice validation, and polymorphic notification channel delivery.
 */
public class CampusNoticeBroadcaster {

    public static void main(String[] args) {
        NotificationChannel email = new EmailChannel();
        NotificationChannel app = new AppChannel();
        NotificationChannel sms = new SmsChannel();

        NoticeStudent asha = new NoticeStudent("Asha", "CSE", List.of(email, app));
        NoticeStudent ravi = new NoticeStudent("Ravi", "ECE", List.of(sms));

        NoticeBoard noticeBoard = new NoticeBoard();
        noticeBoard.registerStudent(asha);
        noticeBoard.registerStudent(ravi);

        noticeBoard.postNotice("Lab Closed Tomorrow", List.of("CSE"));
        noticeBoard.postNotice("Fee Deadline Extended", List.of("CSE", "ECE"));
        noticeBoard.postNotice("Sports Day", List.of());
    }
}

interface NotificationChannel {
    String getChannelName();
    void send(NoticeStudent student, String title);
}

class EmailChannel implements NotificationChannel {
    @Override public String getChannelName() { return "Email"; }
    @Override public void send(NoticeStudent student, String title) {
        System.out.println("[Email → " + student.getName() + "] " + title + ".");
    }
}

class AppChannel implements NotificationChannel {
    @Override public String getChannelName() { return "App"; }
    @Override public void send(NoticeStudent student, String title) {
        System.out.println("[App → " + student.getName() + "] " + title + ".");
    }
}

class SmsChannel implements NotificationChannel {
    @Override public String getChannelName() { return "SMS"; }
    @Override public void send(NoticeStudent student, String title) {
        System.out.println("[SMS → " + student.getName() + "] " + title + ".");
    }
}

class NoticeStudent {
    private String name;
    private String department;
    private List<NotificationChannel> preferredChannels;

    public NoticeStudent(String name, String department, List<NotificationChannel> preferredChannels) {
        this.name = name;
        this.department = department;
        this.preferredChannels = preferredChannels;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<NotificationChannel> getPreferredChannels() {
        return preferredChannels;
    }
}

class NoticeBoard {
    private List<NoticeStudent> students = new ArrayList<>();

    public void registerStudent(NoticeStudent s) {
        students.add(s);
    }

    public boolean postNotice(String title, List<String> targetDepartments) {
        if (title == null || title.trim().isEmpty() || targetDepartments == null || targetDepartments.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return false;
        }

        System.out.println("Notice '" + title + "' posted to " + String.join(", ", targetDepartments) + ".");

        for (NoticeStudent s : students) {
            if (targetDepartments.contains(s.getDepartment())) {
                for (NotificationChannel channel : s.getPreferredChannels()) {
                    channel.send(s, title);
                }
            }
        }
        return true;
    }
}
