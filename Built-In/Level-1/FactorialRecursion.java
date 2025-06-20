import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        int n = takeInput();
        long fact = factorial(n);
        displayResult(n, fact);
    }

    static int takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static void displayResult(int n, long fact) {
        System.out.println("Factorial of " + n + " is " + fact);
    }
}