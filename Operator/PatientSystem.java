class Patient {
    static String hospitalName = "Sunrise Care Hospital";
    private static int totalPatients = 0;

    private final int patientID;    // final
    private String name;
    private int age;
    private String ailment;

    Patient(int patientID, String name, int age, String ailment) { // this
        this.patientID = patientID;
        this.name      = name;
        this.age       = age;
        this.ailment   = ailment;
        totalPatients++;
    }

    static int getTotalPatients() {
        return totalPatients;
    }

    void display() {
        if (this instanceof Patient) {
            System.out.printf("ID:%d %s (%d) — %s @ %s%n",
                    patientID, name, age, ailment, hospitalName);
        }
    }
}

public class PatientSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient(101, "Rahul", 45, "Hypertension");
        Patient p2 = new Patient(102, "Sara", 28, "Fracture");
        p1.display();
        p2.display();
        System.out.println("Total admitted: " + Patient.getTotalPatients());
    }
}
