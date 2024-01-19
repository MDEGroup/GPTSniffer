import java.util.Scanner;

public class SierpinskiTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the order of the Sierpinski triangle: ");
        int order = scanner.nextInt();

        // Display the filled Sierpinski triangle
        String[] triangle = sierpinski(order);
        for (String line : triangle) {
            System.out.println(line);
        }
    }

    public static String[] sierpinski(int order) {
        // Base case
        if (order == 0) {
            return new String[] {"*"};
        }
        
        // Recursively generate the smaller triangles
        String[] smaller = sierpinski(order - 1);
        
        // Combine the smaller triangles to form the larger triangle
        int size = smaller.length;
        String[] larger = new String[size * 2];
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(smaller[i]).append(" ").append(smaller[i]);
            larger[i] = sb.toString();
        }
        for (int i = 0; i < size; i++) {
            larger[size + i] = smaller[i] + " " + smaller[i];
        }
        
        return larger;
    }

}
