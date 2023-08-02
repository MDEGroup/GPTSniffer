



public class PrimeNumberGenerator{
    public static void main(String[] args) {
        StackOfIntegers stackOfIntegers = new StackOfIntegers();
        StackOfIntegers reverseStack = new StackOfIntegers();
        int n = 120;
        for (int i = 2; i < n; i++) {
            if (checkPrime(i)) {
                stackOfIntegers.push(i);
            }
        }

        System.out.println("All prime numbers less than 120, in reverse order: ");
        while (stackOfIntegers.getSize() > 1) {
            System.out.print(stackOfIntegers.pop() + ", ");
        }
        System.out.print(stackOfIntegers.pop());
    }

    static boolean checkPrime(int num) {
        boolean prime = true;
        for (int f = 2; f * f <= num; f++) {
            if (num % f == 0) {
                prime = false;
                break;
            }
        }
        return prime;

    }
}
