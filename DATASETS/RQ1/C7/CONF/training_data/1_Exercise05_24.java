



public class SumSeries{
    public static void main(String[] args) {
        double res = 0.0;
        System.out.println("Cancellation error example calculating from right to left: ");
        for (int i = 1000; i >= 1; i--) {
            res += 1.0 / i;
        }
        System.out.println("Total Sum: " + res);
        double res2 = 0.0;
        System.out.println("Cancellation error example calculating from left to right: ");
        for (int i = 1; i <= 1000; i++) {
            res2 += 1.0 / i;
        }
        System.out.println("Total Sum: " + res2);
        double d = res - res2;
        System.out.println("By going from left to right, we lost accuracy of " + d);
    }
}
