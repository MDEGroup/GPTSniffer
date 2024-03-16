


public class Exercise06_19 {
    public static void main(String[] args) {
        double x1 = -1.356;
        double y1 = 1.743;
        double x2 = -1.377;
        double y2 = 1.929;
        double x3 = -1.432;
        double y3 = 1.711;

        double s1 = findSide(x1, y1, x2, y2);
        double s2 = findSide(x2, y2, x3, y3);
        double s3 = findSide(x1, y1, x3, y3);

        if (isValid(s1, s2, s3)) {
            System.out.println("The area of the triangle is: " + area(s1, s2, s3));
        } else {
            System.out.println("The input for sides, is invalid");
        }

    }


    
    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt((s * (s - side1) * (s - side2) * (s - side3)));
    }

    
    public static boolean isValid(
            double side1, double side2, double side3) {
        if ((side1 + side2) > side3) {
            return false;
        } else if ((side1 + side3) > side2) {
            return false;
        } else if ((side2 + side3) > side1) {
            return false;
        } else {
            return true;
        }
    }

    public static double findSide(double x, double y, double w, double z) {

        return Math.pow(Math.pow(x - w, 2) + Math.pow(y - z, 2), 0.5);
    }
}
