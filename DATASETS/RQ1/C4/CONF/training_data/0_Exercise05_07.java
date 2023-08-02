public class TuitionCalculator {
    public static void main(String[] args) {
        double tuition = 10000.0; 
        double totalCost = 0.0;

        
        for (int i = 1; i <= 10; i++) {
            tuition *= 1.05; 
            if (i > 4) {
                totalCost += tuition; 
            }
        }

        
        System.out.printf("The tuition in ten years is $%.2f\n", tuition);
        System.out.printf("The total cost of four years' worth of tuition after the tenth year is $%.2f\n", totalCost);
    }
}