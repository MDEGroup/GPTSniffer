
public class GreatCircleDistance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double radius = 6371.01; 

        
        double x1Radians = Math.toRadians(x1);
        double y1Radians = Math.toRadians(y1);
        double x2Radians = Math.toRadians(x2);
        double y2Radians = Math.toRadians(y2);

        
        double distance = radius * Math.acos(Math.sin(x1Radians) * Math.sin(x2Radians)
                + Math.cos(x1Radians) * Math.cos(x2Radians) * Math.cos(y1Radians - y2Radians));

        System.out.println("The distance between the two points is " + distance + " km.");
    }
}
