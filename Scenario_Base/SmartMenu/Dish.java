import java.util.List;

public class Dish {
    String name;
    String type;
    List<String> tags;

    public Dish(String name, String type, List<String> tags) {
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    public boolean matches(String keyword) {
        if (name.toLowerCase().contains(keyword.toLowerCase())) return true;
        for (String tag : tags) {
            if (tag.toLowerCase().contains(keyword.toLowerCase())) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - Tags: " + tags;
    }
}
