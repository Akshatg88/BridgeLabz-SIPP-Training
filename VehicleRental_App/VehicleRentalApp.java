package VehicleRental_App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRentalApp {

    private static final List<Vehicle> FLEET = new ArrayList<>();
    private static final Scanner SC = new Scanner(System.in);

    /* ----- seed some demo vehicles ----- */
    private static void seedFleet() {
        FLEET.add(new Bike ("BK‑11", "Yamaha MT‑15",  400,  true));
        FLEET.add(new Bike ("BK‑22", "Honda Activa",  300,  false));
        FLEET.add(new Car  ("CR‑31", "Hyundai i20",  1200,  true));
        FLEET.add(new Car  ("CR‑41", "Maruti Swift", 1100,  false));
        FLEET.add(new Truck("TR‑51", "Tata 407",     2500,  4.0));
        FLEET.add(new Truck("TR‑61", "Eicher Pro",   3200,  6.5));
    }

    private static void listFleet() {
        int i = 1;
        for (Vehicle v : FLEET) {
            System.out.printf("%d) %-25s  ₹%.2f/day%n", i++, v, v.getBaseRate());
        }
    }

    private static void rentVehicle(Customer c) {
        listFleet();
        System.out.print("\nSelect vehicle number to rent: ");
        int choice = SC.nextInt();

        if (choice < 1 || choice > FLEET.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        Vehicle v = FLEET.get(choice - 1);
        System.out.print("How many days? ");
        int days = SC.nextInt();

        double cost = v.calculateRent(days);
        System.out.printf("\n%s rented %s for %d day(s). Total cost = ₹%.2f%n",
                          c.getName(), v, days, cost);
    }

    public static void main(String[] args) {

        seedFleet();                         // preload demo data

        System.out.print("Enter customer id & name: ");
        Customer customer = new Customer(SC.nextInt(), SC.next());

        while (true) {
            System.out.print("""
                              
                              1‑List Fleet
                              2‑Rent a Vehicle
                              0‑Exit
                              Choice: """);
            switch (SC.nextInt()) {
                case 1  -> listFleet();
                case 2  -> rentVehicle(customer);
                case 0  -> { System.out.println("Thank you!"); return; }
                default -> System.out.println("Invalid!");
            }
        }
    }
}
