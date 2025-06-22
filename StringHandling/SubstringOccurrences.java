import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String str = sc.nextLine();
        System.out.print("Enter the substring: ");
        String sub = sc.nextLine();
        int count = 0, idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        System.out.println("Occurrences: " + count);
    }
}