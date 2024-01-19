



public class nan {
    static int fibCalls = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an index in the Fibonacci sequence: ");
        long targetIndex = in.nextInt();


        System.out.println("Fibonacci num at " + targetIndex + " is " + fib(targetIndex));
        System.out.println("Fib method called " + fibCalls + " times.");
        in.close();

    }

    static long fib(long n) {
        if (n <= 1) {
            return n;
        }
        ++fibCalls;
        return fib(n - 1) + fib(n - 2);
    }

}
