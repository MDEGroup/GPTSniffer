public class Location {
    public int row;
    public int column;
    public double maxValue;

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }
}

public class MaxValueLocator {
    public static Location locateLargest(double[][] array) {
        int maxRow = 0;
        int maxColumn = 0;
        double maxVal = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxVal) {
                    maxVal = array[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        return new Location(maxRow, maxColumn, maxVal);
    }

    public static void main(String[] args) {
        double[][] exampleArray = {
            {1.2, 3.4, 5.6},
            {7.8, 9.0, 10.1},
            {11.2, 13.4, 15.6}
        };

        Location maxLocation = locateLargest(exampleArray);

        System.out.println("The maximum value is " + maxLocation.maxValue +
                " at position (" + maxLocation.row + ", " + maxLocation.column + ")");
    }
}