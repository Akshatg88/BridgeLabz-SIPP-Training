public class StringConcatComparison {
    public static void main(String[] args) {
        int count = 10_000;

        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < count; i++) {
            str += "a";
        }
        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        long builderTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append("a");
        }
        long bufferTime = System.nanoTime() - start;

        System.out.println("String Time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder Time: " + builderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer Time: " + bufferTime / 1_000_000.0 + " ms");
    }
}
