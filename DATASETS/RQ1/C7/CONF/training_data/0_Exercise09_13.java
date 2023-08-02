
public class ArrayTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of rows and columns in the array: ");
        int rows = input.nextInt();
        int cols = input.nextInt();

        
        double[][] arr = new double[rows][cols];

        
        System.out.println("Enter the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = input.nextDouble();
            }
        }

        
        double max = arr[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        
        System.out.println("The location of the largest element is " + max +
                " at (" + maxRow + ", " + maxCol + ")");
    }
}
