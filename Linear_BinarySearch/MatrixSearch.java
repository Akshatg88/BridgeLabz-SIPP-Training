// Binary Search Problem 3: Search in 2D Matrix
public class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = matrix[mid / cols][mid % cols];
            if (val == target) return true;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
