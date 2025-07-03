// Vehicle.java
public class Vehicle {
    protected int maxSpeed;
    protected String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.printf("Max speed: %d km/h  Fuel: %s%n", maxSpeed, fuelType);
    }
}

// Car.java
public class Car extends Vehicle {
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car  Seats: " + seatCapacity);
    }
}

// Truck.java
public class Truck extends Vehicle {
    private double cargoTons;

    public Truck(int maxSpeed, String fuelType, double cargoTons) {
        super(maxSpeed, fuelType);
        this.cargoTons = cargoTons;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck  Cargo: " + cargoTons + " t");
    }
}

// Motorcycle.java
public class Motorcycle extends Vehicle {
    private int engineCC;

    public Motorcycle(int maxSpeed, String fuelType, int engineCC) {
        super(maxSpeed, fuelType);
        this.engineCC = engineCC;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle  Engine: " + engineCC + " cc");
    }
}

// TransportDemo.java
public class TransportDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(180, "Petrol", 5),
            new Truck(120, "Diesel", 12.5),
            new Motorcycle(200, "Petrol", 400)
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();               // polymorphic call
            System.out.println();
        }
    }
}
