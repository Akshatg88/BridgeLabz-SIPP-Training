import java.util.*;

abstract class Employee {
    private final int employeeId;
    private final String name;
    private double baseSalary;

    protected Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.printf("%d | %s | %.2f%n", employeeId, name, calculateSalary());
    }
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }
    @Override public double calculateSalary() { return getBaseSalary(); }
    @Override public void assignDepartment(String dept) { this.department = dept; }
    @Override public String getDepartmentDetails() { return department; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;
    public PartTimeEmployee(int id, String name, double hourlyRate) {
        super(id, name, hourlyRate);
    }
    public void setHoursWorked(int hours) { this.hoursWorked = hours; }
    @Override public double calculateSalary() { return getBaseSalary() * hoursWorked; }
    @Override public void assignDepartment(String dept) { this.department = dept; }
    @Override public String getDepartmentDetails() { return department; }
}

public class EMSDemo {
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();
        FullTimeEmployee fte = new FullTimeEmployee(1,"Aria",50_000);
        fte.assignDepartment("Engineering");
        PartTimeEmployee pte = new PartTimeEmployee(2,"Ben",400);
        pte.setHoursWorked(80);
        pte.assignDepartment("Support");
        staff.add(fte); staff.add(pte);
        staff.forEach(Employee::displayDetails);      // polymorphic call
    }
}
