


public class PrimeNumberChecker {
    public static void main(String[] args) {
        int number = 2;
        int count = 0;
        while (number < 10000) {
            if (isPrime(number)) {
                count++;
            }
            number++;
        }
        System.out.println("The number of prime numbers less than 10,000 is: " + count);
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
