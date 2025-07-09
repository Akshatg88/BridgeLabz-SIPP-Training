package VehicleRental_App;
public class Truck extends Vehicle {

    private double loadCapacity;           // in tonnes

    public Truck(String regNo, String model, double baseRate, double loadCapacity) {
        super(regNo, model, baseRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRent(int days) {
        double cost = baseRate * days;
        cost += loadCapacity * 50 * days;   // weight‑based surcharge
        return cost;
    }
}
