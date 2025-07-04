import java.util.*;

abstract class Vehicle {
    private final String vehicleNumber;
    private final String type;
    private double rentalRate;
    protected Vehicle(String number,String type,double rate){
        this.vehicleNumber=number;this.type=type;this.rentalRate=rate;
    }
    public double getRentalRate(){return rentalRate;}
    public void setRentalRate(double r){this.rentalRate=r;}
    public abstract double calculateRentalCost(int days);
}

interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
    public Car(String num,double rate){super(num,"Car",rate);}
    @Override public double calculateRentalCost(int d){ return getRentalRate()*d; }
    @Override public double calculateInsurance(){ return 1500; }
    @Override public String getInsuranceDetails(){ return "Comprehensive"; }
}

class Bike extends Vehicle implements Insurable{
    public Bike(String num,double rate){super(num,"Bike",rate);}
    @Override public double calculateRentalCost(int d){ return getRentalRate()*d*0.8; }
    @Override public double calculateInsurance(){ return 300; }
    @Override public String getInsuranceDetails(){ return "Third‑Party"; }
}

class Truck extends Vehicle implements Insurable{
    public Truck(String num,double rate){super(num,"Truck",rate);}
    @Override public double calculateRentalCost(int d){ return getRentalRate()*d*1.5; }
    @Override public double calculateInsurance(){ return 2500; }
    @Override public String getInsuranceDetails(){ return "Commercial"; }
}

public class RentalDemo{
    public static void main(String[]args){
        List<Vehicle> fleet = List.of(new Car("DL01",2000),
                                      new Bike("DL02",500),
                                      new Truck("DL03",3500));
        int days=3;
        fleet.forEach(v->{
            double rent=v.calculateRentalCost(days);
            double ins=((Insurable)v).calculateInsurance();
            System.out.printf("%s -> Rent:%,.0f  Ins:%,.0f%n", v.getClass().getSimpleName(), rent, ins);
        });
    }
}
