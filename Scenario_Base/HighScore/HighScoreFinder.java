import java.util.List;

public class HighScoreFinder {
    public static int binarySearch(List<Integer> scores, int target) {
        int low = 0, high = scores.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (scores.get(mid) == target) return mid + 1;
            else if (scores.get(mid) < target) high = mid - 1;
            else low = mid + 1;
        }

        return -low - 1;
    }

    public static void checkScore(List<Integer> scores, int playerScore) {
        int result = binarySearch(scores, playerScore);
        if (result > 0) {
            System.out.println("Score found! Your rank is: " + result);
        } else {
            int insertPos = -result - 1;
            if (insertPos >= 100) {
                int needed = scores.get(99) + 1 - playerScore;
                System.out.println("Not in top 100. You need at least " + needed + " more points.");
            } else {
                System.out.println("You are just outside top 100. Keep going!");
            }
        }
    }
}
