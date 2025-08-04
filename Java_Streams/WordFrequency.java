import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isBlank()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            wordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
