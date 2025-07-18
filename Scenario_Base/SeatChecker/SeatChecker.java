public class SeatChecker {
    public static int binarySearch(int[] arr, int seatNumber) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == seatNumber) return mid;
            else if (arr[mid] < seatNumber) low = mid + 1;
            else high = mid - 1;
        }
        return -low - 1; // Nearest suggestion
    }

    public static void searchSeat(int[][] halls, int seatNumber) {
        for (int i = 0; i < halls.length; i++) {
            int pos = binarySearch(halls[i], seatNumber);
            if (pos >= 0) {
                System.out.println("Seat " + seatNumber + " found in Hall " + (i + 1) + " at position " + pos);
                return;
            }
        }
        System.out.println("Seat not found. Suggesting nearest seat...");
        for (int i = 0; i < halls.length; i++) {
            int pos = -binarySearch(halls[i], seatNumber) - 1;
            if (pos < halls[i].length) {
                System.out.println("Nearest available: Hall " + (i + 1) + " Seat " + halls[i][pos]);
                return;
            }
        }
    }
}
