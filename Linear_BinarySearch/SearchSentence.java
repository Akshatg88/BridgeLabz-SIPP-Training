// Linear Search Problem 2: Search Specific Word
public class SearchSentence {
    public static String search(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }
}
