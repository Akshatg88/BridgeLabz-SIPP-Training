import java.io.*;

public class BufferedCopyPerformance {
    public static void main(String[] args) throws IOException {
        String source = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        // Buffered Stream Copy
        long startBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        long endBuffered = System.nanoTime();
        System.out.println("Buffered time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        // Unbuffered Stream Copy
        long startUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destUnbuffered)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }
}
