class Product {
    static double discount = 5.0;          // shared %
    private static int totalProducts = 0;

    private final int productID;           // final
    private String productName;
    private double price;
    private int quantity;

    Product(int productID, String productName, double price, int quantity) { // this
        this.productID   = productID;
        this.productName = productName;
        this.price       = price;
        this.quantity    = quantity;
        totalProducts++;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void display() {
        if (this instanceof Product) {
            double netPrice = price * quantity * (1 - discount / 100);
            System.out.printf("#%d %s x%d → ₹%.2f after %.1f%% off%n",
                    productID, productName, quantity, netPrice, discount);
        }
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Product.updateDiscount(10.0);
        Product p1 = new Product(101, "Wireless Mouse", 599, 2);
        Product p2 = new Product(102, "Mechanical Keyboard", 2999, 1);
        p1.display();
        p2.display();
    }
}
