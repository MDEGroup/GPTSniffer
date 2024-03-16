




public class SumCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer with multiple digits: ");
        long number = input.nextLong();
        System.out.println(sumDigits(number));
    }

    public static int sumDigits(long n) {
        int summed = 0;
        int num1 = (int) (n);

        while (num1 != 0) {
            summed += (num1 % 10);
            num1 = num1 / 10;
        }
        return summed;
    }

}
