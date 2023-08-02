public class EstimatePi {
    public static void main(String[] args) {
        System.out.println("i\tm(i)");
        System.out.println("------------------");
        for (int i = 1; i <= 901; i += 100) {
            System.out.printf("%d\t%.4f\n", i, m(i));
        }
    }
    
    public static double m(int i) {
        double result = 0.0;
        int sign = 1;
        for (int j = 1; j <= i; j++) {
            result += sign * 4.0 / (2 * j - 1);
            sign = -sign;
        }
        return result;
    }
}
