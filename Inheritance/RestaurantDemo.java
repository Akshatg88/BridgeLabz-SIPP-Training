// Person.java
public class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Worker.java
public interface Worker {
    void performDuties();
}

// Chef.java
public class Chef extends Person implements Worker {
    public Chef(String name, int id) { super(name, id); }

    @Override
    public void performDuties() {
        System.out.println(name + " cooks amazing dishes.");
    }
}

// Waiter.java
public class Waiter extends Person implements Worker {
    public Waiter(String name, int id) { super(name, id); }

    @Override
    public void performDuties() {
        System.out.println(name + " serves customers politely.");
    }
}

// RestaurantDemo.java
public class RestaurantDemo {
    public static void main(String[] args) {
        Worker[] staff = {
            new Chef("Arun", 1),
            new Waiter("Neha", 2)
        };
        for (Worker w : staff) w.performDuties();
    }
}
