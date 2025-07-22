abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}

import java.util.*;

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    void addItem(T item) { items.add(item); }
    List<T> getItems() { return items; }

    static void displayItems(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) System.out.println(item);
    }
}

public class SmartWarehouseMain {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("TV"));

        Storage.displayItems(electronicsStorage.getItems());
    }
}
