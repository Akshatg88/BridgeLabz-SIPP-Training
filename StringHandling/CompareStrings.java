import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();
        int len = Math.min(s1.length(), s2.length());
        int cmp = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cmp = s1.charAt(i) - s2.charAt(i);
                break;
            }
        }
        if (cmp == 0) cmp = s1.length() - s2.length();
        if (cmp < 0)
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\"");
        else if (cmp > 0)
            System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\"");
        else
            System.out.println("Both strings are equal");
    }
}