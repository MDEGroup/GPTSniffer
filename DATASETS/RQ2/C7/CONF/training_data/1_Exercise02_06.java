



public class SumDigits {
    public static void main(String[] args) {

        System.out.print("Enter an integer to discover the sum of its digits: ");

        Scanner input = new Scanner(System.in);

        int userNumber = input.nextInt();


        System.out.println(sumDigits(userNumber));


    }

    private static int sumDigits(int a) {

        int sum = 0;
        while (a > 0) {

            sum += (a % 10);

            a /= 10;
        }


        return sum;

    }

}
