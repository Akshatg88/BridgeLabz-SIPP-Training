public class Ticket {
    User user;
    Event event;

    public Ticket(User user, Event event) {
        this.user = user;
        this.event = event;
        System.out.println("Ticket issued for " + user.name + " to " + event.eventName);
    }
}
