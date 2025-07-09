package VehicleRental_App;
public class Car extends Vehicle {

    private boolean gps;

    public Car(String regNo, String model, double baseRate, boolean gps) {
        super(regNo, model, baseRate);
        this.gps = gps;
    }

    @Override
    public double calculateRent(int days) {
        double cost = baseRate * days;
        if (gps) cost += 100;              // flat GPS fee

        // simple “weekend / long‑trip” surcharge: +5 % if ≥3 days
        if (days >= 3) cost += 0.05 * cost;
        return cost;
    }
}
