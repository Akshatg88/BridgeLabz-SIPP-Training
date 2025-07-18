import java.util.Arrays;

public class SmartMenuMain {
    public static void main(String[] args) {
        MenuSystem menu = new MenuSystem();

        menu.addDish(new Dish("Paneer Tikka", "Starter", Arrays.asList("spicy", "paneer")));
        menu.addDish(new Dish("Veg Biryani", "Main Course", Arrays.asList("rice", "spicy")));
        menu.addDish(new Dish("Gulab Jamun", "Dessert", Arrays.asList("sweet")));

        menu.search("spicy");
        menu.search("chicken");
    }
}
