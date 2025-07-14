import java.util.*;

public class SlidingWindowMax {
    public static void slidingMax(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of the window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }
            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            // Print the max
            if (i >= k - 1) {
                System.out.print(nums[deque.peek()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        slidingMax(arr, k); // Output: 3 3 5 5 6 7
    }
}
