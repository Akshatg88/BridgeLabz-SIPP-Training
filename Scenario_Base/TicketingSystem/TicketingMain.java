public class TicketingMain {
    public static void main(String[] args) {
        TicketingSystem ts = new TicketingSystem();

        ts.bookTicket("Rock Concert", new Attendee("John", 25));
        ts.bookTicket("Rock Concert", new Attendee("Mary", 22, "mary@example.com"));
        ts.bookTicket("Tech Talk", new Attendee("Alice", 30));

        ts.getPosition("Rock Concert", "Mary");
        ts.getPosition("Rock Concert", "John");
        ts.getPosition("Rock Concert", "Alex");
    }
}
