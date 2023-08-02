
public class ParabolaConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = input.nextInt();
        System.out.print("Enter the value of b: ");
        int b = input.nextInt();
        System.out.print("Enter the value of c: ");
        int c = input.nextInt();

        int h = -b / (2 * a);
        int k = a * h * h + b * h + c;

        System.out.println("The vertex form of the parabola is: y = " + a + "(x - " + h + ")^2 + " + k);
    }
}
