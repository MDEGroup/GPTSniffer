import java.util.*;

public class TetrahedronVolumeDeterminant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the coordinates of the first vertex:");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double z1 = sc.nextDouble();
        
        System.out.println("Enter the coordinates of the second vertex:");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double z2 = sc.nextDouble();
        
        System.out.println("Enter the coordinates of the third vertex:");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        double z3 = sc.nextDouble();
        
        System.out.println("Enter the coordinates of the fourth vertex:");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();
        double z4 = sc.nextDouble();
        
        double volume = calculateVolume(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
        
        System.out.println("The volume of the tetrahedron is " + volume);
    }
    
    private static double calculateVolume(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3, double x4, double y4, double z4) {
        double a11 = x2 - x1;
        double a12 = y2 - y1;
        double a13 = z2 - z1;
        double a21 = x3 - x1;
        double a22 = y3 - y1;
        double a23 = z3 - z1;
        double a31 = x4 - x1;
        double a32 = y4 - y1;
        double a33 = z4 - z1;
        
        double determinant = a11 * (a22 * a33 - a23 * a32) - a12 * (a21 * a33 - a23 * a31) + a13 * (a21 * a32 - a22 * a31);
        
        return Math.abs(determinant) / 6.0;
    }
}

