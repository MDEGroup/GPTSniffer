import java.util.Random;

public class CoinFlip {
    public static void main(String[] args) {
        Random random = new Random();
        int heads = 0;
        int tails = 0;

        for (int i = 0; i < 1000000; i++) {
            if (random.nextBoolean()) {
                heads++;
            } else {
                tails++;
            }
        }

        System.out.printf("Heads: %d%n", heads);
        System.out.printf("Tails: %d%n", tails);
    }
}