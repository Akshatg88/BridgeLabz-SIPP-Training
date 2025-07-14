public class CountingSortAges {
    public static void countingSort(int[] ages) {
        int max = 18, min = 10;
        int[] count = new int[max - min + 1];

        // Count frequencies
        for (int age : ages) count[age - min]++;

        // Reconstruct sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) ages[index++] = i + min;
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 11, 18, 14, 10, 16, 13};
        countingSort(ages);
        System.out.println("Sorted Ages:");
        for (int age : ages) System.out.print(age + " ");
    }
}
