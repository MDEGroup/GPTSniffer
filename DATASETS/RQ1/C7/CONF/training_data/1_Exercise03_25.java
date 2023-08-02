



public class IntersectingPoint{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double x1, x2, x3, x4, y1, y2, y3, y4;
        try {
            x1 = in.nextDouble();
            y1 = in.nextDouble();
            x2 = in.nextDouble();
            y2 = in.nextDouble();
            x3 = in.nextDouble();
            y3 = in.nextDouble();
            x4 = in.nextDouble();
            y4 = in.nextDouble();




            double a, b, c, d, e, f;
            a = y1 - y2;
            b = -(x1 - x2);
            c = y3 - y4;
            d = -(x3 - x4);
            e = a * x1 - b * y1;
            f = c * x3 - d * y3;

            double DxDy = a * d - b * c;

            if (DxDy < 0.000000001) {
                System.out.println("The equation has no solution because the lines are parallel.");

            } else {

                double x = (e * d - b * f) / DxDy;  
                double y = (a * f - e * c) / DxDy;  

                System.out.println("The intersecting point is at (" + x + "," + y + ")");
            }


        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Please enter values matching the prompt.");
            System.out.println(e.toString());
        }


    }
}
