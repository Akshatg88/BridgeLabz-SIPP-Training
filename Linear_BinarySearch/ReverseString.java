// StringBuilder Problem 1: Reverse a String
public class ReverseString {
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
