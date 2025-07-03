// Order.java
import java.time.LocalDate;

public class Order {
    protected int orderId;
    protected LocalDate orderDate;

    public Order(int orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() { return "Placed"; }
}

// ShippedOrder.java
public class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int id, LocalDate date, String trackingNumber) {
        super(id, date);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() { return "Shipped"; }
}

// DeliveredOrder.java
public class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(int id, LocalDate date,
                          String tracking, LocalDate deliveryDate) {
        super(id, date, tracking);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() { return "Delivered"; }
}

// OrderDemo.java
import java.time.LocalDate;

public class OrderDemo {
    public static void main(String[] args) {
        Order o1 = new Order(1, LocalDate.now());
        Order o2 = new ShippedOrder(2, LocalDate.now(), "AB123");
        Order o3 = new DeliveredOrder(3, LocalDate.now().minusDays(2),
                                      "CD456", LocalDate.now());

        for (Order o : new Order[]{o1, o2, o3}) {
            System.out.printf("Order %d → %s%n", o.orderId, o.getOrderStatus());
        }
    }
}
