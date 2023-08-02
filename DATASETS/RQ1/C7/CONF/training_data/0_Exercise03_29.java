
public class CircleOverlap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the center coordinates and radius of the first circle: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double r1 = scanner.nextDouble();

        
        System.out.println("Enter the center coordinates and radius of the second circle: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double r2 = scanner.nextDouble();

        
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        
        if (distance + r2 <= r1) {
            System.out.println("The second circle is inside the first circle.");
        } else if (distance < r1 + r2) {
            System.out.println("The circles overlap.");
        } else {
            System.out.println("The circles do not overlap.");
        }

        scanner.close();
    }
}
