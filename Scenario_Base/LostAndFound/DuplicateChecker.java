import java.util.HashSet;

public class DuplicateChecker {
    private static final HashSet<String> entries = new HashSet<>();

    public static boolean isDuplicate(String itemDesc) {
        return !entries.add(itemDesc.toLowerCase());
    }
}
