


public class Calculator {
    public static void main(String[] args) {
        System.out.println("i                 m(i)");
        System.out.println("__________________________");
        double res = 0;

        for (int num = 1; num <= 20; num++) {
            System.out.print(num + "          ");
            res += num / (num + 1.0);
            System.out.printf("         %.4f\n", res);

        }
    }
}
