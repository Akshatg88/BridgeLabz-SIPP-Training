import java.util.*;

abstract class Product {
    private final String productId;
    private String name;
    private double price;
    protected Product(String productId,String name,double price){
        this.productId=productId;this.name=name;this.price=price;
    }
    public String getProductId(){return productId;}
    public String getName(){return name;}
    public void setName(String n){this.name=n;}
    public double getPrice(){return price;}
    public void setPrice(double p){this.price=p;}
    public abstract double calculateDiscount();
}

interface Taxable{
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable{
    public Electronics(String id,String n,double p){super(id,n,p);}
    @Override public double calculateDiscount(){ return getPrice()*0.10; }   // 10 % off
    @Override public double calculateTax(){ return getPrice()*0.18; }        // 18 % GST
    @Override public String getTaxDetails(){ return "GST 18 %"; }
}

class Clothing extends Product implements Taxable{
    public Clothing(String id,String n,double p){super(id,n,p);}
    @Override public double calculateDiscount(){ return getPrice()*0.20; }   // promo
    @Override public double calculateTax(){ return getPrice()*0.05; }
    @Override public String getTaxDetails(){ return "VAT 5 %"; }
}

class Groceries extends Product {   // non‑taxable for demo
    public Groceries(String id,String n,double p){super(id,n,p);}
    @Override public double calculateDiscount(){ return 0; }
}

public class ShopDemo{
    static void printFinalPrice(List<Product> basket){
        basket.forEach(p -> {
            double tax = (p instanceof Taxable t)? t.calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - p.calculateDiscount();
            System.out.printf("%s -> %.2f%n", p.getName(), finalPrice);
        });
    }
    public static void main(String[] args){
        List<Product> cart = List.of(
            new Electronics("E01","Laptop",60000),
            new Clothing("C01","T‑Shirt",1200),
            new Groceries("G01","Rice (5 kg)",350)
        );
        printFinalPrice(cart);            // polymorphic
    }
}
