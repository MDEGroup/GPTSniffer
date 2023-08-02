public static boolean isMarkovMatrix(double[][] m) {
    int n = m.length;
    for (int j = 0; j < n; j++) {
        double columnSum = 0;
        for (int i = 0; i < n; i++) {
            if (m[i][j] < 0) // check if the element is negative
                return false;
            columnSum += m[i][j];
        }
        if (Math.abs(columnSum - 1.0) > 0.0001) // check if the column sum is 1
            return false;
    }
    return true;
}