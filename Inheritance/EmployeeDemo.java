// Employee.java
public class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.printf("ID:%d  Name:%s  Salary:₹%.2f%n", id, name, salary);
    }
}

// Manager.java
public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager  Team size: " + teamSize);
    }
}

// Developer.java
public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String language) {
        super(name, id, salary);
        this.programmingLanguage = language;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer  Language: " + programmingLanguage);
    }
}

// Intern.java
public class Intern extends Employee {
    private String mentor;

    public Intern(String name, int id, double salary, String mentor) {
        super(name, id, salary);
        this.mentor = mentor;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern  Mentor: " + mentor);
    }
}

// EmployeeDemo.java
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Manager("Asha", 101, 90000, 8),
            new Developer("Ravi", 102, 70000, "Java"),
            new Intern("Pooja", 103, 20000, "Asha")
        };

        for (Employee e : staff) {
            e.displayDetails();
            System.out.println();
        }
    }
}
