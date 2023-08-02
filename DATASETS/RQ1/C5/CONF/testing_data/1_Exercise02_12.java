


public class MinRunwayLengthForTakeoff{
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter speed (meters/second) and acceleration (meters/second squared): ");
        double speed = input.nextDouble();
        double accel = input.nextDouble();


        System.out.printf("The length of runway need is: %2.3f", Math.pow(speed, 2) / (2 * accel));
    }
}
