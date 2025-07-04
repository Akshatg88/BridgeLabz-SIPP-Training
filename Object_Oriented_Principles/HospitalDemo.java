import java.util.*;

abstract class Patient{
    private final int patientId;
    private final String name;
    private int age;
    protected Patient(int id,String n,int age){this.patientId=id;this.name=n;this.age=age;}
    public abstract double calculateBill();
    public String getPatientDetails(){ return patientId+" – "+name; }
}

interface MedicalRecord{
    void addRecord(String notes);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord{
    private final List<String> records=new ArrayList<>();
    private int daysStayed; private double dailyRate=2000;
    public InPatient(int id,String n,int age,int days){super(id,n,age);this.daysStayed=days;}
    @Override public double calculateBill(){ return daysStayed*dailyRate; }
    @Override public void addRecord(String notes){ records.add(notes); }
    @Override public List<String> viewRecords(){ return records; }
}

class OutPatient extends Patient implements MedicalRecord{
    private final List<String> records=new ArrayList<>();
    private double consultationFee=500;
    public OutPatient(int id,String n,int age){super(id,n,age);}
    @Override public double calculateBill(){ return consultationFee; }
    @Override public void addRecord(String notes){ records.add(notes); }
    @Override public List<String> viewRecords(){ return records; }
}

public class HospitalDemo{
    public static void main(String[]args){
        List<Patient> pts=List.of(
            new InPatient(1,"Ria",30,4),
            new OutPatient(2,"Sam",25));
        pts.forEach(p->System.out.printf("%s -> Bill: %.0f%n",p.getPatientDetails(),p.calculateBill()));
    }
}
