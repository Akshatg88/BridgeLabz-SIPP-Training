class Employee {
    static String companyName = "Tech Dynamics Ltd";
    private static int totalEmployees = 0;

    private final int id;      // final
    private String name;
    private String designation;

    Employee(int id, String name, String designation) { // this
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void display() {
        if (this instanceof Employee) {
            System.out.printf("[%d] %s — %s (%s)%n",
                    id, name, designation, companyName);
        }
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Riya",  "Software Engineer");
        Employee e2 = new Employee(2, "Kunal", "QA Analyst");
        e1.display();
        e2.display();
        Employee.displayTotalEmployees();
    }
}
