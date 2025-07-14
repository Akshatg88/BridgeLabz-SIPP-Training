// FileReader Problem 2: Count Word Occurrence
import java.io.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String target = "java";
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(target)) count++;
            }
        }
        br.close();
        System.out.println("Occurrences of '" + target + "': " + count);
    }
}
