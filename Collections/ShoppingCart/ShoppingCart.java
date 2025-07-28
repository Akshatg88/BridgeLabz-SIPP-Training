import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> priceMap = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void displayCartInOrder() {
        System.out.println("Cart in insertion order:");
        for (String product : cart.keySet()) {
            System.out.println(product + " x" + cart.get(product) + " @ ₹" + priceMap.get(product));
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = priceMap.get(product);
            sorted.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("Cart sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " x" + cart.get(product) + " @ ₹" + entry.getKey());
            }
        }
    }
}
