
public class TriangleAreaDeterminant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the coordinates of the first point:");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        
        System.out.println("Enter the coordinates of the second point:");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        
        System.out.println("Enter the coordinates of the third point:");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        
        double area = calculateArea(x1, y1, x2, y2, x3, y3);
        
        System.out.println("The area of the triangle is " + area);
    }
    
    private static double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double determinant = x1 * (y2 - y3) - y1 * (x2 - x3) + x2 * y3 - x3 * y2;
        return Math.abs(determinant) / 2.0;
    }
}

