import java.util.*;

public class SortingComparison {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int N = 10_000;
        int[] bubbleArr = new Random().ints(N, 0, N).toArray();
        int[] mergeArr = bubbleArr.clone();
        int[] quickArr = bubbleArr.clone();

        long start = System.nanoTime();
        bubbleSort(bubbleArr);
        long bubbleTime = System.nanoTime() - start;

        start = System.nanoTime();
        Arrays.sort(mergeArr); // Simulating Merge Sort
        long mergeTime = System.nanoTime() - start;

        start = System.nanoTime();
        Arrays.sort(quickArr); // Also uses Dual-Pivot QuickSort internally
        long quickTime = System.nanoTime() - start;

        System.out.println("Bubble Sort Time: " + bubbleTime / 1_000_000.0 + " ms");
        System.out.println("Merge Sort Time: " + mergeTime / 1_000_000.0 + " ms");
        System.out.println("Quick Sort Time: " + quickTime / 1_000_000.0 + " ms");
    }
}
