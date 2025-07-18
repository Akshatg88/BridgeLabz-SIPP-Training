import java.time.LocalDate;
import java.util.*;

public class MoodTracker {
    private final HashMap<LocalDate, List<String>> moodMap = new HashMap<>();

    public void logMood(LocalDate date, String mood) {
        moodMap.putIfAbsent(date, new ArrayList<>());
        moodMap.get(date).add(mood.toLowerCase());
    }

    public void searchMood(String mood) {
        int count = 0;
        List<LocalDate> matchedDates = new ArrayList<>();

        for (Map.Entry<LocalDate, List<String>> entry : moodMap.entrySet()) {
            if (entry.getKey().isAfter(LocalDate.now().minusDays(30))) {
                for (String m : entry.getValue()) {
                    if (m.equalsIgnoreCase(mood)) {
                        count++;
                        matchedDates.add(entry.getKey());
                    }
                }
            }
        }

        System.out.println("Mood '" + mood + "' logged " + count + " times.");
        if (!matchedDates.isEmpty()) {
            System.out.println("Dates: " + matchedDates);
        }
    }
}
