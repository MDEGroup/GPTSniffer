
public class PointInCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a point (x, y): ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        
        if (distance <= 10) {
            System.out.println("The point (" + x + ", " + y + ") is inside the circle.");
        } else {
            System.out.println("The point (" + x + ", " + y + ") is outside the circle.");
        }

        scanner.close();
    }
}
