import java.io.*;

public class UserInfoToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("userinfo.txt")) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Favorite programming language: ");
            String lang = reader.readLine();

            writer.write("Name: " + name + "\nAge: " + age + "\nLanguage: " + lang);
            System.out.println("Information saved to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
