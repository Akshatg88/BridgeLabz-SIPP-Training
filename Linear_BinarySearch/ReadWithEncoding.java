// InputStreamReader Problem 1: Read file with charset
import java.io.*;

public class ReadWithEncoding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
