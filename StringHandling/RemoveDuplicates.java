import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        System.out.println("String after removing duplicates: " + sb.toString());
    }
}