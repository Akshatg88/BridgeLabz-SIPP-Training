package VehicleRental_App;
public abstract class Vehicle implements Rentable {

    /* ---------- protected so subclasses can see them ---------- */
    protected String regNo;
    protected String model;
    protected double baseRate;        // ₹ / day

    public Vehicle(String regNo, String model, double baseRate) {
        this.regNo   = regNo;
        this.model   = model;
        this.baseRate = baseRate;
    }

    /* ---------- getters (encapsulation) ---------- */
    public String getRegNo()  { return regNo; }
    public String getModel()  { return model; }
    public double getBaseRate() { return baseRate; }

    /* subclasses supply the concrete formula */
    @Override
    public abstract double calculateRent(int days);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + regNo + ", " + model + "]";
    }
}
