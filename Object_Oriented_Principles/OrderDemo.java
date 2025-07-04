import java.util.*;

abstract class FoodItem{
    private final String itemName;
    private double price;
    private int quantity;
    protected FoodItem(String n,double p,int q){itemName=n;price=p;quantity=q;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public void setQuantity(int q){quantity=q;}
    public abstract double calculateTotalPrice();
    public String getItemDetails(){return itemName+" x"+quantity;}
}

interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable{
    public VegItem(String n,double p,int q){super(n,p,q);}
    @Override public double calculateTotalPrice(){ return getPrice()*getQuantity() - applyDiscount(); }
    @Override public double applyDiscount(){ return getPrice()*getQuantity()*0.05; }
    @Override public String getDiscountDetails(){ return "5 % Veg Discount"; }
}

class NonVegItem extends FoodItem implements Discountable{
    public NonVegItem(String n,double p,int q){super(n,p,q);}
    @Override public double calculateTotalPrice(){ return getPrice()*getQuantity() + 20 - applyDiscount(); }
    @Override public double applyDiscount(){ return getPrice()*getQuantity()*0.02; }
    @Override public String getDiscountDetails(){ return "2 % Promo"; }
}

public class OrderDemo{
    public static void main(String[]args){
        List<FoodItem> order=List.of(
            new VegItem("Paneer Tikka",250,2),
            new NonVegItem("Chicken Wings",300,1));
        order.forEach(i->System.out.printf("%s -> %.2f%n",i.getItemDetails(),i.calculateTotalPrice()));
    }
}
