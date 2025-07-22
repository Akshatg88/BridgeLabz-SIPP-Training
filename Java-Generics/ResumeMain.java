abstract class JobRole {
    String name;
    JobRole(String name) { this.name = name; }
    public String toString() { return name; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() { super("Software Engineer"); }
}

class DataScientist extends JobRole {
    DataScientist() { super("Data Scientist"); }
}

class ProductManager extends JobRole {
    ProductManager() { super("Product Manager"); }
}

class Resume<T extends JobRole> {
    T role;
    String candidateName;

    Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public void review() {
        System.out.println("Reviewing " + role + " resume for " + candidateName);
    }

    static void processAll(List<? extends JobRole> roles) {
        for (JobRole r : roles) System.out.println("Screening role: " + r);
    }
}

import java.util.*;

public class ResumeMain {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Akshat", new SoftwareEngineer());
        r1.review();

        List<JobRole> roles = Arrays.asList(new SoftwareEngineer(), new DataScientist());
        Resume.processAll(roles);
    }
}
