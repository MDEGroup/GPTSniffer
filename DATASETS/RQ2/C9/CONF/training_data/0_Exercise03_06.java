import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight in pounds: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in feet and inches.\nFeet: ");
        int feet = scanner.nextInt();
        System.out.print("Inches: ");
        int inches = scanner.nextInt();

        int heightInInches = feet * 12 + inches;
        double heightInMeters = heightInInches * 0.0254;

        double bmi = weight / (heightInMeters * heightInMeters);
        System.out.printf("Your BMI is %.2f\n", bmi);
    }
}