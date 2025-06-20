import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String input = takeInput();
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }

    static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    static boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right)
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        return true;
    }

    static void displayResult(String s, boolean isPalin) {
        if (isPalin)
            System.out.println("\"" + s + "\" is a palindrome.");
        else
            System.out.println("\"" + s + "\" is not a palindrome.");
    }
}