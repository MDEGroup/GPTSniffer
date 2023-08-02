public class PiApproximation {
    public static void main(String[] args) {
        double pi1 = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11);
        double pi2 = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);
        
        System.out.println("Approximation 1: " + pi1);
        System.out.println("Approximation 2: " + pi2);
    }
}