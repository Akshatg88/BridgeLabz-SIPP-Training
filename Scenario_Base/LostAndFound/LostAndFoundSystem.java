import java.util.*;

public class LostAndFoundSystem {
    private HashMap<String, LinkedList<String>> record = new HashMap<>();

    public void addItem(String type, String description) {
        if (DuplicateChecker.isDuplicate(description)) {
            System.out.println("Duplicate item: " + description);
            return;
        }

        record.putIfAbsent(type, new LinkedList<>());
        record.get(type).add(description);
        System.out.println("Item added: " + description + " under " + type);
    }

    public void searchItem(String type, String keyword) {
        LinkedList<String> items = record.get(type);
        if (items == null) {
            System.out.println("No items found under type: " + type);
            return;
        }

        int position = 0;
        boolean found = false;
        for (String item : items) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found at position " + position + ": " + item);
                found = true;
            }
            position++;
        }

        if (!found) System.out.println("No match found for keyword: " + keyword);
    }
}
