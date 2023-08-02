import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        BigDecimal number = new BigDecimal("10000000000000000000000000000000000000000000000000"); // 50-digit number
        
        while (count < 10) {
            if (number.remainder(new BigDecimal("2")).equals(BigDecimal.ZERO) ||
                    number.remainder(new BigDecimal("3")).equals(BigDecimal.ZERO)) {
                System.out.println(number);
                count++;
            }
            number = number.add(BigDecimal.ONE);
        }
    }
}
