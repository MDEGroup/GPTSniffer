


public class Exercise06_14 {
    public static void main(String[] args) {
        System.out.println("i               m(i)");
        System.out.println("----------------------");
        double sum = 0;
        boolean addOrSubtract = false; 

        for (int i = 1; i < 1000; i += 100) {
            System.out.print(i + "          ");
            System.out.printf("       %.4f\n", pi(i));

        }
    }

    static double pi(double num) {
        double res = 0;
        for (int i = 1; i <= num; i++) {
            res += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return res * 4;
    }
}