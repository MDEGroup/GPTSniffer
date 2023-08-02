public class SumSeries {
    public static void main(String[] args) {
        int n = 50000;
        double sumLR = 0.0; // sum from left to right
        double sumRL = 0.0; // sum from right to left
        
        // Compute sum from left to right
        for (int i = 1; i <= n; i += 2) {
            sumLR += (double)i / (i + 2);
        }
        
        // Compute sum from right to left
        for (int i = n; i >= 1; i -= 2) {
            sumRL += (double)i / (i + 2);
        }
        
        // Display results
        System.out.printf("Sum from left to right: %.5f\n", sumLR);
        System.out.printf("Sum from right to left: %.5f\n", sumRL);
    }
}
