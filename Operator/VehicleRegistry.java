class Vehicle {
    static double registrationFee = 2500.0;
    private final String registrationNumber; // final
    private String ownerName;
    private String vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) { // this
        this.ownerName          = ownerName;
        this.vehicleType        = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void display() {
        if (this instanceof Vehicle) {
            System.out.printf("%s (%s) → Reg# %s | Fee ₹%.0f%n",
                    ownerName, vehicleType, registrationNumber, registrationFee);
        }
    }
}

public class VehicleRegistry {
    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(3000.0);
        Vehicle v1 = new Vehicle("Sameer", "Car", "MH14AB1234");
        Vehicle v2 = new Vehicle("Divya",  "Bike", "DL09XY9876");
        v1.display();
        v2.display();
    }
}
