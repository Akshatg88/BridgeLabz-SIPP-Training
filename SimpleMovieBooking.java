import java.util.Scanner;

public class SimpleMovieBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        String choice;

        System.out.println(" Welcome to Movie Booking ");

        do {
            System.out.println("\nSelect Seat Type:");
            System.out.println("1. Silver  - ₹150");
            System.out.println("2. Gold    - ₹250");
            System.out.println("3. Premium - ₹350");
            int seat = sc.nextInt();
            System.out.print("Enter number of seats: ");
            int seatQty = sc.nextInt();

            if (seat == 1) total += seatQty * 150;
            else if (seat == 2) total += seatQty * 250;
            else if (seat == 3) total += seatQty * 350;
            else System.out.println("Invalid seat choice.");
            System.out.println("\nSelect Eatables:");
            System.out.println("1. Popcorn - ₹100");
            System.out.println("2. Coke    - ₹80");
            System.out.println("3. Nachos  - ₹120");
            int food = sc.nextInt();
            System.out.print("Enter quantity: ");
            int foodQty = sc.nextInt();

            if (food == 1) total += foodQty * 100;
            else if (food == 2) total += foodQty * 80;
            else if (food == 3) total += foodQty * 120;
            else System.out.println("Invalid food choice.");
            System.out.print("\nDo you want to add more? (yes/no): ");
            sc.nextLine(); 
            choice = sc.nextLine().trim().toLowerCase();

        } while (choice.equals("yes"));
        System.out.println("\n Total Amount to Pay: ₹" + total);
        System.out.println(" Booking Complete.");
        sc.close();
    }
}
