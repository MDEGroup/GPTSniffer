public static double[][] multiplyMatrix(double[][] a, double[][] b) {  int m = a.length; // number of rows in A  int n = b[0].length; // number of columns in B  int p = b.length; // number of rows in B  double[][] c = new double[m][n];  for (int i = 0; i < m; i++) {    for (int j = 0; j < n; j++) {      double sum = 0.0;      for (int k = 0; k < p; k++) {        sum += a[i][k] * b[k][j];      }      c[i][j] = sum;    }  }  return c;}