



public class LargeElementLocator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] arrTwoDim = new double[2][5];
        System.out.println("To input a two dimensional array, input: 5 floating point numbers now: ");

        for (int i = 0; i < 5; i++) {
            arrTwoDim[0][i] = in.nextDouble();
        }

        System.out.println("Input more 5 floating point numbers now: ");

        for (int i = 0; i < 5; i++) {
            arrTwoDim[1][i] = in.nextDouble();
        }

        System.out.println("The largest is located at " + Arrays.toString(locateLargest(arrTwoDim)));


    }

    public static int[] locateLargest(double[][] a) {
        int[] largeIdx = new int[2];
        double largest = Double.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > largest) {
                    largest = a[i][j];
                    largeIdx[0] = i;
                    largeIdx[1] = j;
                }
            }
        }
        return largeIdx;
    }
}
