import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        int[] nums = takeInput();
        int max = findMax(nums[0], nums[1], nums[2]);
        System.out.println("Maximum: " + max);
    }

    static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        System.out.print("Enter three integers: ");
        for (int i = 0; i < 3; i++) nums[i] = sc.nextInt();
        return nums;
    }

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}