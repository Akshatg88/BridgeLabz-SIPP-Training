// Course.java
public class Course {
    protected String courseName;
    protected int durationWeeks;

    public Course(String name, int durationWeeks) {
        this.courseName = name;
        this.durationWeeks = durationWeeks;
    }
}

// OnlineCourse.java
public class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String name, int weeks,
                        String platform, boolean isRecorded) {
        super(name, weeks);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

// PaidOnlineCourse.java
public class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String name, int weeks, String platform,
                            boolean recorded, double fee, double discount) {
        super(name, weeks, platform, recorded);
        this.fee = fee;
        this.discount = discount;
    }

    public void showDetails() {
        System.out.printf("%s (%d weeks) on %s → Fee ₹%.2f  Discount %.0f%%%n",
                          courseName, durationWeeks, platform, fee, discount);
    }
}

// CourseDemo.java
public class CourseDemo {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse("DSA in Java", 10,
                                "Coursera", true, 7999, 20);
        poc.showDetails();
    }
}
