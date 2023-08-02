
public class ApproximateE {
    public static void main(String[] args) {
        for (int i = 100; i <= 1000; i += 100) {
            BigDecimal e = BigDecimal.ZERO;
            for (int j = 0; j <= i; j++) {
                e = e.add(BigDecimal.ONE.divide(factorial(j), 25, BigDecimal.ROUND_HALF_UP));
            }
            System.out.printf("e for i=%d: %s\n", i, e);
        }
    }
    
    public static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}
