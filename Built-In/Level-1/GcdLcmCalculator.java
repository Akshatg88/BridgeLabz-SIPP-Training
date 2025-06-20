import java.util.Scanner;

public class GcdLcmCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        int gcd = gcd(a, b);
        int lcm = lcm(a, b);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}