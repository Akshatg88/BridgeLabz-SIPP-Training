import java.util.*;

public class TicketingSystem {
    HashMap<String, Queue<Attendee>> eventMap = new HashMap<>();

    public void bookTicket(String eventName, Attendee attendee) {
        eventMap.putIfAbsent(eventName, new LinkedList<>());
        eventMap.get(eventName).add(attendee);
        System.out.println(attendee.name + " booked for " + eventName);
    }

    public void getPosition(String eventName, String attendeeName) {
        Queue<Attendee> queue = eventMap.get(eventName);
        if (queue == null) {
            System.out.println("Event not found.");
            return;
        }

        int pos = 1;
        for (Attendee a : queue) {
            if (a.name.equals(attendeeName)) {
                System.out.println(attendeeName + " is at position " + pos + " in " + eventName);
                return;
            }
            pos++;
        }
        System.out.println("Attendee not found in queue.");
    }
}
