


public class MeterConverter {
    public static void main(String[] args) {
        System.out.println("Feet                Meters              |            Meters                  Feet");
        System.out.println(
                "___________________________________________________________________________________");
        for (int f = 1, m = 20; f <= 10; f++, m += 5) { 
            double feet = f; 
            double meters = m; 
            if (f <= 9) {
                System.out.print(" "); 
            }
            System.out.printf("%-2.1f                 %.3f", feet, footToMeter(feet));
            System.out.print("              |            ");
            System.out.printf("%2.1f                   %.3f\n", meters, meterToFoot(meters));

        }
    }

    
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }


}
