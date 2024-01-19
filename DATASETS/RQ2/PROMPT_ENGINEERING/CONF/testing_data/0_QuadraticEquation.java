public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
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
        // Example usage
        QuadraticEquation equation = new QuadraticEquation(1, -3, 2);
        double discriminant = equation.getDiscriminant();
        double root1 = equation.getRoot1();
        double root2 = equation.getRoot2();

        System.out.println("Discriminant: " + discriminant);
        System.out.println("Root 1: " + root1);
        System.out.println("Root 2: " + root2);
    }
}