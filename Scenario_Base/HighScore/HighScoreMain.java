import java.util.*;

public class HighScoreMain {
    public static void main(String[] args) {
        List<Integer> topScores = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            topScores.add(1000 - i * 5); // Scores: 1000, 995, 990, ...
        }

        HighScoreFinder.checkScore(topScores, 980);
        HighScoreFinder.checkScore(topScores, 450);
    }
}
