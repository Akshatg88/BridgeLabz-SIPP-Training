public class VotingMain {
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");

        system.displayResultsInOrder();
        system.displaySortedResults();
    }
}
