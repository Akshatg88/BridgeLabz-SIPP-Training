import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        String feedback;
        int guess;
        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (true) {
            guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            feedback = sc.nextLine().toLowerCase();
            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number.");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
        sc.close();
    }

    static int generateGuess(int low, int high) {
        return (low + high) / 2; // or use: new Random().nextInt(high - low + 1) + low;
    }
}