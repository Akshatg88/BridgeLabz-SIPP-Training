import java.util.*;

public class MenuSystem {
    private List<Dish> menu = new ArrayList<>();
    private Set<String> addedDishes = new HashSet<>();

    public void addDish(Dish dish) {
        if (addedDishes.contains(dish.name.toLowerCase())) {
            System.out.println("Duplicate dish: " + dish.name);
            return;
        }
        menu.add(dish);
        addedDishes.add(dish.name.toLowerCase());
    }

    public void search(String keyword) {
        boolean found = false;
        for (Dish dish : menu) {
            if (dish.matches(keyword)) {
                System.out.println(dish);
                found = true;
            }
        }
        if (!found) System.out.println("No matching dishes found.");
    }
}
