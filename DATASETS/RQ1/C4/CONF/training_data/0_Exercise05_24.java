public class SumSeries {
    public static void main(String[] args) {
        int n = 50000;
        double sumLR = 0.0; 
        double sumRL = 0.0; 
        
        
        for (int i = 1; i <= n; i += 2) {
            sumLR += (double)i / (i + 2);
        }
        
        
        for (int i = n; i >= 1; i -= 2) {
            sumRL += (double)i / (i + 2);
        }
        
        
        System.out.printf("Sum from left to right: %.5f\n", sumLR);
        System.out.printf("Sum from right to left: %.5f\n", sumRL);
    }
}
