import java.util.*;

abstract class Vehicle{
    private final String vehicleId;
    private String driverName;
    private double ratePerKm;
    protected Vehicle(String id,String driver,double rate){
        this.vehicleId=id;this.driverName=driver;this.ratePerKm=rate;
    }
    public abstract double calculateFare(double dist);
    public String getVehicleDetails(){ return vehicleId+" – "+driverName; }
}

interface GPS{
    String getCurrentLocation();
    void updateLocation(String loc);
}

class Car extends Vehicle implements GPS{
    private String location=""; public Car(String id,String d,double r){super(id,d,r);}
    @Override public double calculateFare(double km){ return km*1.0*getMultiplier(); }
    private double getMultiplier(){ return 1.2; }
    @Override public String getCurrentLocation(){ return location; }
    @Override public void updateLocation(String loc){ this.location=loc; }
}

class Bike extends Vehicle implements GPS{
    private String location=""; public Bike(String id,String d,double r){super(id,d,r);}
    @Override public double calculateFare(double km){ return km*0.8*getMultiplier(); }
    private double getMultiplier(){ return 1.0; }
    @Override public String getCurrentLocation(){ return location; }
    @Override public void updateLocation(String loc){ this.location=loc; }
}

class Auto extends Vehicle implements GPS{
    private String location=""; public Auto(String id,String d,double r){super(id,d,r);}
    @Override public double calculateFare(double km){ return km*0.9*getMultiplier(); }
    private double getMultiplier(){ return 1.1; }
    @Override public String getCurrentLocation(){ return location; }
    @Override public void updateLocation(String loc){ this.location=loc; }
}

public class RideDemo{
    public static void main(String[]args){
        List<Vehicle> rides=List.of(new Car("C1","Dev",15),
                                    new Bike("B1","Eva",7),
                                    new Auto("A1","Far",10));
        double distance=12.5;
        rides.forEach(v->System.out.printf("%s -> Fare: %.0f%n",
                           v.getVehicleDetails(), v.calculateFare(distance)));
    }
}
