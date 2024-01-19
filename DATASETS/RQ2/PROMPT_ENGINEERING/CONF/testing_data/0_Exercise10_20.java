import java.math.BigDecimal;
import java.math.MathContext;

public class ApproximateE {

    public static void main(String[] args) {
        System.out.println("Approximating the value of e:");

        int[] iValues = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        for (int i : iValues) {
            BigDecimal eApproximation = calculateE(i);
            System.out.println("For i = " + i + ", e ≈ " + eApproximation.toPlainString());
        }
    }

    public static BigDecimal calculateE(int n) {
        BigDecimal eApprox = BigDecimal.ONE; // Initializing e to 1
        BigDecimal factorial = BigDecimal.ONE; // Initializing factorial to 1

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i)); // Compute factorial
            BigDecimal term = BigDecimal.ONE.divide(factorial, 25, BigDecimal.ROUND_HALF_UP); // Calculate term
            eApprox = eApprox.add(term); // Add term to e
        }

        return eApprox;
    }
}