
public class CountSingleDigits {
    public static void main(String[] args) {
        int[] counts = new int[10]; 

        Random rand = new Random(); 
        for (int i = 0; i < 100; i++) {
            int num = rand.nextInt(10); 
            counts[num]++; 
        }

        
        for (int i = 0; i < 10; i++) {
            System.out.printf("Count for %d: %d\n", i, counts[i]);
        }
    }
}
