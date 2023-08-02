
public class NumberCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] counts = new int[101]; 

        
        int number;
        do {
            System.out.print("Enter an integer between 1 and 100 (0 to stop): ");
            number = input.nextInt();
            if (number >= 1 && number <= 100) {
                counts[number]++; 
            }
        } while (number != 0);

        
        for (int i = 1; i <= 100; i++) {
            if (counts[i] > 0) {
                System.out.println(i + " occurs " + counts[i] + " times");
            }
        }
    }
}
