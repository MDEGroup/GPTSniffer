
class Calc1 {
    public double method1(int n) {
        double doubleTotal = 0;
        if (n <= 12) {
            doubleTotal = n * 0.06;
        } else if (12 < n && n <= 46) {
            doubleTotal = (12 * 0.06) + (n - 12) * 0.15;
        } else if (46 < n && n <= 88) {
            doubleTotal = (12 * 0.06) + (34 * 0.15) + (n - 46) * 0.24;
        } else if (88 < n && n <= 150) {
            doubleTotal = (12 * 0.06) + (34 * 0.15) + (42 * 0.24) + (n - 88) * 0.35;
        } else if (150 < n && n <= 300) {
            doubleTotal = (12 * 0.06) + (34 * 0.15) + (42 * 0.24) + (88 * 0.35) + (n - 150) * 0.38;
        } else if (300 < n && n <= 500) {
            doubleTotal = (12 * 0.06) + (34 * 0.15) + (42 * 0.24) + (88 * 0.35) + (150 * 0.38) + (n - 300) * 0.4;
        } else if (500 < n && n <= 1000) {
            doubleTotal = (12 * 0.06) + (34 * 0.15) + (42 * 0.24) + (88 * 0.35) + (150 * 0.38) + (300 * 0.4)
                    + (n - 500) * 0.42;
        } else {
            doubleTotal = (12 * 0.06) + (34 * 0.15) + (42 * 0.24) + (88 * 0.35) + (150 * 0.38) + (300 * 0.4)
                    + (500 * 0.42)
                    + (n - 1000) * 0.45;
        }
        doubleTotal = (double) Math.round(doubleTotal * 100) / 100;

        return doubleTotal;
    }
}

class Calc2 {
    public double method2(int n) {
        double totalTax2 = 0;
        if (n <= 12) {
            totalTax2 = 0; 
        } else if (12 < n && n <= 46) {
            totalTax2 = (n * 0.15) - 1.08;
        } else if (46 < n && n <= 88) {
            totalTax2 = (n * 0.24) - 5.22;
        } else if (88 < n && n <= 150) {
            totalTax2 = (n * 0.35) - 14.90;
        } else if (150 < n && n <= 300) {
            totalTax2 = (n * 0.38) - 19.40;
        } else if (300 < n && n <= 500) {
            totalTax2 = (n * 0.4) - 25.40;
        } else if (500 < n && n <= 1000) {
            totalTax2 = (n * 0.42) - 35.40;
        } else {
            totalTax2 = (n * 0.45) - 65.40;
        }

        return totalTax2;
    }
}

public class mini8 {

    static void details(int n) {
        int[] numVar = { 12, 34, 42, 88, 150, 300, 500, 10000 };
        double[] rateVar = { 0.06, 0.15, 0.24, 0.35, 0.38, 0.4, 0.42, 0.45 };
        if (n <= 12) {
            System.out.println(numVar[0] * 1000000 + " * " + rateVar[0] * 100 + " = " + numVar[0] * rateVar[0]);
        } else if (12 < n && n <= 46) {
            for (int i = 0; i < 1; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 12) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 12) * rateVar[1] * 1000000);
        } else if (46 < n && n <= 88) {
            for (int i = 0; i < 2; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 46) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 46) * rateVar[1] * 1000000);
        } else if (88 < n && n <= 150) {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 88) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 88) * rateVar[1] * 1000000);
        } else if (150 < n && n <= 300) {
            for (int i = 0; i < 4; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 150) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 150) * rateVar[1] * 1000000);
        } else if (300 < n && n <= 500) {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 300) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 300) * rateVar[1] * 1000000);
        } else if (500 < n && n <= 1000) {
            for (int i = 0; i < 6; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 500) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 500) * rateVar[1] * 1000000);
        } else {
            for (int i = 0; i < 7; i++) {
                System.out.printf("%d * %.0f", numVar[i] * 1000000, rateVar[i] * 100);
                System.out.print("% = ");
                System.out.printf("%.0f\n", numVar[i] * rateVar[i] * 1000000);
            }
            System.out.printf("%d * %.0f", (n - 10000) * 1000000, rateVar[1] * 100);
            System.out.print("% = ");
            System.out.printf("%.0f\n", (n - 10000) * rateVar[1] * 1000000);
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Calc1 calc1 = new Calc1();
        Calc2 calc2 = new Calc2();

        int salary;
        do {
            System.out.println("[과세금액 계산 프로그램]");
            System.out.print("연소득을 입력해 주세요. : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            salary = Integer.parseInt(br.readLine());
            br.close();
        } while (salary < 1);

        System.out.println();
        mini8.details(salary / 1000000);
        System.out.println();

        System.out.printf("[세율에 의한 세금]: %.0f\n", calc1.method1(salary / 1000000) * 1000000);
        System.out.printf("[누진공제 계산에 의한 세금]:  %.0f", calc2.method2(salary / 1000000) * 1000000);

    }
}