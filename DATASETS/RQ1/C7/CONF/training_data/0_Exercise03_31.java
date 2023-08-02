
public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the exchange rate from dollars to RMB: ");
        double rate = input.nextDouble();

        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        int direction = input.nextInt();

        if (direction == 0) {
            System.out.print("Enter the dollar amount: ");
            double dollars = input.nextDouble();
            double rmb = dollars * rate;
            System.out.println("$" + dollars + " is " + rmb + " yuan.");
        } else if (direction == 1) {
            System.out.print("Enter the RMB amount: ");
            double rmb = input.nextDouble();
            double dollars = rmb / rate;
            System.out.println(rmb + " yuan is $" + dollars + ".");
        } else {
            System.out.println("Invalid input.");
        }
    }
}
