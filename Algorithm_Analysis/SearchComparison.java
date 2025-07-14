import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int[] data = new int[1_000_000];
        for (int i = 0; i < data.length; i++) data[i] = i;

        int target = 999_999;

        // Linear Search
        long start = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) break;
        }
        long linearTime = System.nanoTime() - start;

        // Binary Search
        start = System.nanoTime();
        Arrays.binarySearch(data, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
        System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
    }
}
