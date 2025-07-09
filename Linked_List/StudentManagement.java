import java.util.Scanner;

public class StudentManagement {

    /* ---------- Node ---------- */
    static class Student {
        int rollNo, age;
        String name, grade;
        Student next;

        Student(int rollNo, String name, int age, String grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    /* ---------- SLL Core ---------- */
    static class StudentList {
        private Student head;

        /* insert */
        void addFirst(Student s) { s.next = head; head = s; }
        void addLast(Student s) {
            if (head == null) { head = s; return; }
            Student t = head;
            while (t.next != null) t = t.next;
            t.next = s;
        }
        void addAt(int pos, Student s) {
            if (pos <= 0) { addFirst(s); return; }
            Student t = head;
            for (int i = 0; t != null && i < pos - 1; i++) t = t.next;
            if (t == null) return;
            s.next = t.next; t.next = s;
        }

        /* delete/search/update */
        void deleteByRoll(int roll) {
            if (head == null) return;
            if (head.rollNo == roll) { head = head.next; return; }
            Student t = head;
            while (t.next != null && t.next.rollNo != roll) t = t.next;
            if (t.next != null) t.next = t.next.next;
        }
        Student find(int roll) {
            for (Student t = head; t != null; t = t.next)
                if (t.rollNo == roll) return t;
            return null;
        }
        void updateGrade(int roll, String g) {
            Student s = find(roll);
            if (s != null) s.grade = g;
        }

        /* display */
        void display() {
            for (Student t = head; t != null; t = t.next)
                System.out.printf("Roll:%d  Name:%s  Age:%d  Grade:%s%n",
                                  t.rollNo, t.name, t.age, t.grade);
        }
    }

    /* ---------- Demo / simple menu ---------- */
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                \n1 Add  2 Delete  3 Search  4 UpdateGrade  5 Display  0 Exit : """);
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.print("Roll Name Age Grade: ");
                    list.addLast(new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.next()));
                }
                case 2 -> { System.out.print("Roll: "); list.deleteByRoll(sc.nextInt()); }
                case 3 -> {
                    System.out.print("Roll: "); Student s = list.find(sc.nextInt());
                    System.out.println(s == null ? "Not found" :
                            s.rollNo+" "+s.name+" "+s.age+" "+s.grade);
                }
                case 4 -> {
                    System.out.print("Roll & new grade: ");
                    list.updateGrade(sc.nextInt(), sc.next());
                }
                case 5 -> list.display();
                case 0 -> { sc.close(); return; }
            }
        }
    }
}
