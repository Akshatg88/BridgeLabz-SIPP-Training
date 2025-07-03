// Person.java
public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Teacher.java
public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.printf("%s (Teacher) → Subject: %s%n", name, subject);
    }
}

// Student.java
public class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.printf("%s (Student) → Grade: %s%n", name, grade);
    }
}

// Staff.java
public class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.printf("%s (Staff) → Dept: %s%n", name, department);
    }
}

// SchoolDemo.java
public class SchoolDemo {
    public static void main(String[] args) {
        Person[] people = {
            new Teacher("Dr. Rao", 45, "Physics"),
            new Student("Kiran", 20, "3rd Year"),
            new Staff("Ms. Lata", 38, "Administration")
        };

        for (Person p : people) {
            if (p instanceof Teacher t)  t.displayRole();
            if (p instanceof Student s)  s.displayRole();
            if (p instanceof Staff st)   st.displayRole();
        }
    }
}
