import java.io.*;
import java.nio.file.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String inputImage = "image.jpg";
        String outputImage = "copy_image.jpg";

        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(inputImage));
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b;
            while ((b = bais.read()) != -1) {
                baos.write(b);
            }

            Files.write(Paths.get(outputImage), baos.toByteArray());
            System.out.println("Image copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
