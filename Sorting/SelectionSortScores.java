public class SelectionSortScores {
    public static void selectionSort(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIdx]) minIdx = j;
            }
            int temp = scores[minIdx]; scores[minIdx] = scores[i]; scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 88, 64, 91, 78};
        selectionSort(scores);
        System.out.println("Sorted Exam Scores:");
        for (int score : scores) System.out.print(score + " ");
    }
}
