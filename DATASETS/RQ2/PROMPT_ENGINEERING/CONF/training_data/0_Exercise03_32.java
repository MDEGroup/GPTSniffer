import java.util.Scanner;

public class PointPosition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter three points
        System.out.print("Enter three points for p0, p1, and p2: ");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        
        // Determine the position of p2 relative to the line from p0 to p1
        double position = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        
        // Display the result
        if (position > 0) {
            System.out.println("p2 is on the left side of the line from p0 to p1");
        } else if (position < 0) {
            System.out.println("p2 is on the right side of the line from p0 to p1");
        } else {
            System.out.println("p2 is on the same line as the line from p0 to p1");
        }
    }
}