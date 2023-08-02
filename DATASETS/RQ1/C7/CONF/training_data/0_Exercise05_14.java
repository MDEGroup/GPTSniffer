
public class GcdCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first positive integer: ");
        int n1 = input.nextInt();

        System.out.print("Enter the second positive integer: ");
        int n2 = input.nextInt();

        int gcd = 1;
        int d = Math.min(n1, n2);

        while (d >= 1) {
            if (n1 % d == 0 && n2 % d == 0) {
                gcd = d;
                break;
            }
            d--;
        }

        System.out.println("The greatest common divisor of " + n1 + " and " + n2 + " is " + gcd);
    }
}
