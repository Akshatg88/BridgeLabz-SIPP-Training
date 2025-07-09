package VehicleRental_App;
public class Bike extends Vehicle {

    private boolean helmetIncluded;

    public Bike(String regNo, String model, double baseRate, boolean helmetIncluded) {
        super(regNo, model, baseRate);
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public double calculateRent(int days) {
        double cost = baseRate * days;
        if (!helmetIncluded) {
            cost += 25 * days;             // small surcharge for helmet rental
        }
        return cost;
    }
}
