import java.util.*;

public class DataStructureSearch {
    public static void main(String[] args) {
        int N = 1_000_000;
        int target = N - 1;
        int[] arr = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        // Array Search
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) break;
        }
        long arrayTime = System.nanoTime() - start;

        // HashSet Search
        start = System.nanoTime();
        hashSet.contains(target);
        long hashTime = System.nanoTime() - start;

        // TreeSet Search
        start = System.nanoTime();
        treeSet.contains(target);
        long treeTime = System.nanoTime() - start;

        System.out.println("Array Search Time: " + arrayTime / 1_000_000.0 + " ms");
        System.out.println("HashSet Search Time: " + hashTime / 1_000_000.0 + " ms");
        System.out.println("TreeSet Search Time: " + treeTime / 1_000_000.0 + " ms");
    }
}
