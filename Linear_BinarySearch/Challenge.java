import java.io.*;
import java.nio.charset.StandardCharsets;

public class Challenge {
    public static void main(String[] args) throws IOException {
        // Compare StringBuilder and StringBuffer
        String str = "hello";
        int repeat = 1_000_000;

        long start = System.nanoTime();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < repeat; i++) sb1.append(str);
        long builderTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < repeat; i++) sb2.append(str);
        long bufferTime = System.nanoTime() - start;

        System.out.println("Builder: " + builderTime / 1_000_000 + " ms");
        System.out.println("Buffer : " + bufferTime / 1_000_000 + " ms");

        // FileReader and InputStreamReader comparison
        File file = new File("large.txt");

        // FileReader
        long words = 0;
        start = System.nanoTime();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        String line;
        while ((line = fr.readLine()) != null)
            words += line.split("\\s+").length;
        fr.close();
        long fileReaderTime = System.nanoTime() - start;
        System.out.println("Words (FileReader): " + words);
        System.out.println("Time (FileReader): " + fileReaderTime / 1_000_000 + " ms");

        // InputStreamReader
        words = 0;
        start = System.nanoTime();
        BufferedReader isr = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        while ((line = isr.readLine()) != null)
            words += line.split("\\s+").length;
        isr.close();
        long inputStreamTime = System.nanoTime() - start;
        System.out.println("Words (InputStreamReader): " + words);
        System.out.println("Time (InputStreamReader): " + inputStreamTime / 1_000_000 + " ms");
    }
}
