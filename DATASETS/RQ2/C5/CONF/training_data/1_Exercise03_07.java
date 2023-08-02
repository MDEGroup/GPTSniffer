


public class DisplayAmountInWords {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        System.out.print(
                "Enter an amount in double, for example 11.56: ");
        double amount = in.nextDouble();

        int remainingAmount = (int) (amount * 100);

        int numberOfOneDollars = remainingAmount / 100;
        remainingAmount %= 100;

        int numberOfQuarters = remainingAmount / 25;
        remainingAmount %= 25;

        int numberOfDimes = remainingAmount / 10;
        remainingAmount %= 10;

        int numberOfNickles = remainingAmount / 5;
        remainingAmount %= 5;

        int numberOfPennies = remainingAmount;

        System.out.println("Your amount " + amount + " consists of: ");
        System.out.println("   " + numberOfOneDollars + (numberOfOneDollars == 1 ? " dollar" : " one dollars"));
        System.out.println("   " + numberOfQuarters + (numberOfQuarters == 1 ? " quarter" : " quarters"));
        System.out.println("   " + numberOfDimes + (numberOfDimes == 1 ? " dime" : " dimes"));
        System.out.println("   " + numberOfNickles + (numberOfNickles == 1 ? " nickel" : " nickels"));
        System.out.println("   " + numberOfPennies + (numberOfPennies == 1 ? " penny" : " pennies"));

    }

}
