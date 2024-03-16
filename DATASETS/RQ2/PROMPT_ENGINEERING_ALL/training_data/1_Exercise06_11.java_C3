


public class Exercise06_11 {
    public static void main(String[] args) {
        System.out.println("Sales  Commission Amount");
        for (int sales = 10000; sales <= 100000; sales += 5000) {
            System.out.print(sales);
            System.out.print("   ");
            System.out.printf("%.1f\n", computeCommission(sales));
        }

    }

    public static double computeCommission(double salesAmount) {
        double commission = 0;
        if (salesAmount <= 5000) {
            commission = salesAmount * 0.08;

        } else if (salesAmount <= 10000) {
            salesAmount -= 5000;
            commission = (5000 * 0.08) + (salesAmount * .10);

        } else if (salesAmount > 10000) {
            commission = (5000 * 0.08);
            salesAmount -= 5000;

            commission += (5000 * .10);
            salesAmount -= 5000;

            commission += salesAmount * .12;
        }
        return commission;
    }
}