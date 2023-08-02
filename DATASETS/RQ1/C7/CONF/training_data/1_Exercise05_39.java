



public class SalesCommissionCalculator{
    public static void main(String[] args) {
        final double TARGET = 30000;
        double actual = 0;
        double bal = 0;
        double sales = 0;
        do {
            bal = actual = 0;
            sales += 0.01;

            if (sales > 10000)
                actual += (bal = sales - 10000) * 0.12;

            if (sales > 5000)
                actual += (bal -= bal - 5000) * 0.10;

            if (sales > 0)
                actual += bal * 0.08;

        } while (actual < TARGET);

        System.out.printf("Sales required to earn $30,000 of commission is $%.2f\n", sales);
    }
}
