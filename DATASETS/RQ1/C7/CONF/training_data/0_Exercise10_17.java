
public class SquareNumbers {
    public static void main(String[] args) {
        BigInteger max = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger low = BigInteger.valueOf(1);
        BigInteger high = max.sqrt();

        for (int i = 0; i < 10; i++) {
            BigInteger mid = (low.add(high)).shiftRight(1);
            BigInteger square = mid.multiply(mid);

            if (square.compareTo(max) > 0) {
                System.out.println(square);
                low = mid.add(BigInteger.ONE);
            } else {
                high = mid.subtract(BigInteger.ONE);
            }
        }
    }
}
