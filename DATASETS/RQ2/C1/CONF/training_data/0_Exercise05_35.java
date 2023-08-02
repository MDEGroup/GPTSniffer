public class Summation {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 624; i++) {
            double term = 1 / (Math.sqrt(i) + Math.sqrt(i + 1));
            sum += term;
        }
        System.out.println("The summation is: " + sum);
    }
}