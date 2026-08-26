public class CompareStringBufferBuilder {

    public static void main(String[] args) {
        int n = 1_000_000;

        StringBuffer sbf = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbf.append("hello");
        }
        long endBuffer = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        long endBuilder = System.nanoTime();

        long bufferTime = endBuffer - startBuffer;
        long builderTime = endBuilder - startBuilder;

        System.out.println("StringBuffer time: " + bufferTime + " ns");
        System.out.println("StringBuilder time: " + builderTime + " ns");

        if (builderTime < bufferTime) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
}