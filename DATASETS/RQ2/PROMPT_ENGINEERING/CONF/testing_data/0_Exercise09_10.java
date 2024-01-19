import java.util.Scanner;

public class QuadEquation {
    private double a;
    private double b;
    private double c;

    public QuadEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return 0;
        } else {
            return (-this.b + Math.sqrt(discriminant)) / (2 * this.a);
        }
    }

    public double getRoot2() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return 0;
        } else {
            return (-this.b - Math.sqrt(discriminant)) / (2 * this.a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter values for a, b, and c:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        
        QuadEquation equation = new QuadEquation(a, b, c);
        double discriminant = equation.getDiscriminant();
        
        if (discriminant > 0) {
            System.out.println("Root 1: " + equation.getRoot1());
            System.out.println("Root 2: " + equation.getRoot2());
        } else if (discriminant == 0) {
            System.out.println("Single Root: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots.");
        }
        
        scanner.close();
    }
}