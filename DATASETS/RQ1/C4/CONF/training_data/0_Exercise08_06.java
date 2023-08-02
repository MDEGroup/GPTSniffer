public static double[][] multiplyMatrix(double[][] a, double[][] b) {
    int m = a.length; 
    int n = b[0].length; 
    int p = b.length; 

    double[][] c = new double[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            double sum = 0.0;
            for (int k = 0; k < p; k++) {
                sum += a[i][k] * b[k][j];
            }
            c[i][j] = sum;
        }
    }

    return c;
}