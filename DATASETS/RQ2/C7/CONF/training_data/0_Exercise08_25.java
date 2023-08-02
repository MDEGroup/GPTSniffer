public static boolean isMarkovMatrix(double[][] m) {  int n = m.length;  for (int j = 0; j < n; j++) {    double columnSum = 0;    for (int i = 0; i < n; i++) {      if (m[i][j] < 0) 
