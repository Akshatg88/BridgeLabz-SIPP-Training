class MyHashMap {
    static class Entry {
        int key, value;
        Entry next;
        Entry(int k, int v) {
            key = k; value = v;
        }
    }

    private static final int SIZE = 16;
    private Entry[] table = new Entry[SIZE];

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Entry head = table[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Entry newEntry = new Entry(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public Integer get(int key) {
        int index = getIndex(key);
        Entry head = table[index];

        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Entry head = table[index], prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev != null) prev.next = head.next;
                else table[index] = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 100);
        map.put(2, 200);
        System.out.println("Get 1: " + map.get(1)); // 100
        map.remove(1);
        System.out.println("Get 1 after removal: " + map.get(1)); // null
    }
}
