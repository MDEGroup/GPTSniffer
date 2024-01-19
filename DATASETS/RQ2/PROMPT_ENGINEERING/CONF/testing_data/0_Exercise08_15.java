import java.util.Scanner;

public class CheckSameLine {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] points = new double[5][2];
        
        System.out.print("Enter five points: ");
        for (int i = 0; i < 5; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
        
        if (arePointsOnSameLine(points)) {
            System.out.println("The five points are on the same line");
        } else {
            System.out.println("The five points are not on the same line");
        }
        
        input.close();
    }
    
    public static boolean arePointsOnSameLine(double[][] points) {
        if (points.length < 3) {
            return true;
        }
        
        double x0 = points[0][0];
        double y0 = points[0][1];
        
        for (int i = 1; i < points.length - 1; i++) {
            double x1 = points[i][0];
            double y1 = points[i][1];
            double x2 = points[i + 1][0];
            double y2 = points[i + 1][1];
            
            if ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) != 0) {
                return false;
            }
        }
        
        return true;
    }
}