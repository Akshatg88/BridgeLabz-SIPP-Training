import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws IOException {
        File file = new File("largefile.txt"); // Assume a large file exists

        long start = System.nanoTime();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        while (fr.readLine() != null) {}
        long fileReaderTime = System.nanoTime() - start;
        fr.close();

        start = System.nanoTime();
        BufferedReader isr = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        while (isr.readLine() != null) {}
        long inputStreamTime = System.nanoTime() - start;
        isr.close();

        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamTime / 1_000_000.0 + " ms");
    }
}
