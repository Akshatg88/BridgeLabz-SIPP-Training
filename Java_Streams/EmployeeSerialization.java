import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + ", " + name + ", " + department + ", " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(101, "Alice", "HR", 50000),
            new Employee(102, "Bob", "IT", 60000)
        );

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> list = (List<Employee>) ois.readObject();
            list.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
