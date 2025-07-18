import java.time.LocalDate;

public class MoodTrackerMain {
    public static void main(String[] args) {
        MoodTracker tracker = new MoodTracker();

        tracker.logMood(LocalDate.now(), "Happy");
        tracker.logMood(LocalDate.now().minusDays(1), "Tired");
        tracker.logMood(LocalDate.now().minusDays(5), "Sad");
        tracker.logMood(LocalDate.now().minusDays(1), "Happy");

        tracker.searchMood("happy");
        tracker.searchMood("angry");
    }
}
