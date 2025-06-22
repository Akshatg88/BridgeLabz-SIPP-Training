import java.util.Scanner;

public class PalindromeStringCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        boolean isPalin = true;
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                isPalin = false;
                break;
            }
            l++; r--;
        }
        if (isPalin)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }
}