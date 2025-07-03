// Vehicle.java
public class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
}

// Refuelable.java
public interface Refuelable {
    void refuel();
}

// ElectricVehicle.java
public class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging...");
    }
}

// PetrolVehicle.java
public class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling petrol...");
    }
}

// VehicleHybridDemo.java
public class VehicleHybridDemo {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 225);
        PetrolVehicle pv  = new PetrolVehicle("Maruti Swift", 180);

        ev.charge();
        pv.refuel();
    }
}
