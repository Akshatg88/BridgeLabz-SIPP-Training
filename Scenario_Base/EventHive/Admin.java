public class Admin implements EventManager {
    @Override
    public void modifyEvent(String eventName) {
        System.out.println("Modifying event: " + eventName);
    }

    @Override
    public void removeEvent(String eventName) {
        System.out.println("Removing event: " + eventName);
    }
}
