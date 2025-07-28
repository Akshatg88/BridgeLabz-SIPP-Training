import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
    }

    public void displayResultsInOrder() {
        System.out.println("Vote order:");
        voteOrderMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public void displaySortedResults() {
        TreeMap<String, Integer> sorted = new TreeMap<>(voteMap);
        System.out.println("Sorted Results:");
        sorted.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
