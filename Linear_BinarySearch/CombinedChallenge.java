import java.util.*;

public class CombinedChallenge {
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) if (num > 0) set.add(num);
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
