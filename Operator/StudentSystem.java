class Student {
    static String universityName = "Global Institute of Technology";
    private static int totalStudents = 0;

    private final int rollNumber;   // final
    private String name;
    private char grade;

    Student(int rollNumber, String name, char grade) { // this
        this.rollNumber = rollNumber;
        this.name       = name;
        this.grade      = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Enrolled: " + totalStudents);
    }

    void display() {
        if (this instanceof Student) {
            System.out.printf("%s: %s [%c] - %s%n",
                    rollNumber, name, grade, universityName);
        }
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Arjun", 'A');
        Student s2 = new Student(2, "Meera", 'B');
        s1.display();
        s2.display();
        Student.displayTotalStudents();
    }
}
