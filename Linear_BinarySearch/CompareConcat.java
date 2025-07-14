// StringBuffer Problem 2: Compare StringBuffer vs StringBuilder
public class CompareConcat {
    public static void main(String[] args) {
        int count = 1_000_000;

        long start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) sbf.append("hello");
        long timeBuffer = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < count; i++) sbd.append("hello");
        long timeBuilder = System.nanoTime() - start;

        System.out.println("StringBuffer time: " + timeBuffer / 1_000_000 + " ms");
        System.out.println("StringBuilder time: " + timeBuilder / 1_000_000 + " ms");
    }
}
