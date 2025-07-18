public class EventHiveMain {
    public static void main(String[] args) {
        Event event = new Event("Hackathon 2025");
        User user = new User("Alice");
        Ticket ticket = user.register(event);

        Admin admin = new Admin();
        admin.modifyEvent("Hackathon 2025");
        admin.removeEvent("Old Tech Talk");
    }
}
