interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() { return "Book"; }
}

class ClothingCategory implements Category {
    public String getCategoryName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    public String getCategoryName() { return "Gadget"; }
}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void display() {
        System.out.println(name + " - " + category.getCategoryName() + " - ₹" + price);
    }
}

class DiscountUtil {
    public static <T extends Category> void applyDiscount(Product<T> p, double percent) {
        p.price -= p.price * (percent / 100);
    }
}

public class MarketplaceMain {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Guide", 500, new BookCategory());
        book.display();
        DiscountUtil.applyDiscount(book, 20);
        book.display();
    }
}
