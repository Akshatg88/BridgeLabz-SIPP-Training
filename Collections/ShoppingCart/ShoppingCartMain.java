public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 75000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);

        cart.addToCart("Mouse", 2);
        cart.addToCart("Laptop", 1);
        cart.addToCart("Keyboard", 1);

        cart.displayCartInOrder();
        cart.displaySortedByPrice();
    }
}
