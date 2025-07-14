// Binary Search Problem 4: First and Last Occurrence
public class FirstLastOccurrence {
    public static int[] searchRange(int[] nums, int target) {
        return new int[] {findFirst(nums, target), findLast(nums, target)};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) res = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return res;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) res = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return res;
    }
}
