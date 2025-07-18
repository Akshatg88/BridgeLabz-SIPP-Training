public class Attendee {
    String name;
    int age;
    String email;

    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Attendee(String name, int age, String email) {
        this(name, age);
        this.email = email;
    }
}
