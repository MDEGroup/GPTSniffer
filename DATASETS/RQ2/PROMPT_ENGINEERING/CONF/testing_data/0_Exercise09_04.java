import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Random rand = new Random(1000);
        
        System.out.println("Generating 50 random numbers between 0 and 100:");
        for (int i = 0; i < 50; i++) {
            int randomNumber = rand.nextInt(100);
            System.out.println("Random number " + (i + 1) + ": " + randomNumber);
        }
    }
}