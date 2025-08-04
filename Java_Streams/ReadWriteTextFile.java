import java.io.*;

public class ReadWriteTextFile {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        if (!inputFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
