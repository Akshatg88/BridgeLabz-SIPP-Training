import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String file = "students.dat";

        // Write
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.5);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(9.1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println(roll + ", " + name + ", " + gpa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
