import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        String remarks="";

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            physics[i] = sc.nextDouble();
            chemistry[i] = sc.nextDouble();
            maths[i] = sc.nextDouble();

            percent[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

            if (percent[i] >= 80){
                grade[i] = "A";
                remarks = "Level 4,above agency normalized standard";
            }
            else if (percent[i] >= 70 && percent[i] < 80){
                grade[i] = "B";
                remarks = "Level 3,at agency normalized standard";
            }
            else if (percent[i] >= 60 && percent[i] < 70){
                grade[i] = "C";
                remarks = "Level 2,but approaching agency normalized standard";
            }
            else if (percent[i] >= 50  && percent[i] < 60){
                grade[i] = "D";
                remarks = "Level 1,well below agency normalized standard";
            }
                else if (percent[i] >= 40 && percent[i] < 50){
                grade[i] = "E";
                remarks = "Level 1-,too below agency normalized standard";
            }
            else{
                grade[i] = "R";
                remarks = "Remedial Student";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: Physics=%.1f, Chemistry=%.1f, Maths=%.1f, Percentage=%.2f%%, Grade=%s%n",
                i + 1, physics[i], chemistry[i], maths[i], percent[i], grade[i], remarks);
        }
    }
}
