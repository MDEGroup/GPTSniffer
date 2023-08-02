



public class RandomObjectCreator{
    private static final int seed = 1000;
    private static final int n = 100;

    public static void main(String[] args) {
        Random random = new Random(seed);
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) System.out.println();

            System.out.print(random.nextInt(n) + " ");
        }
    }
}
