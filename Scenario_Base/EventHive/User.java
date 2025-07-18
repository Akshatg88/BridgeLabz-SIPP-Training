public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public Ticket register(Event event) {
        return new Ticket(this, event);
    }
}
