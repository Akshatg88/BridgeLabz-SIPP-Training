public class MergeSortBooks {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        System.arraycopy(prices, left, leftArr, 0, leftArr.length);
        System.arraycopy(prices, mid + 1, rightArr, 0, rightArr.length);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length)
            prices[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];

        while (i < leftArr.length) prices[k++] = leftArr[i++];
        while (j < rightArr.length) prices[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] prices = {450, 320, 510, 295, 620};
        mergeSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Book Prices:");
        for (int price : prices) System.out.print(price + " ");
    }
}
