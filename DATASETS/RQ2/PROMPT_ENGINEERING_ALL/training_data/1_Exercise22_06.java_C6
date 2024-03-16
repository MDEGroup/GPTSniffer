


public class Main{

    
    public static void main(String[] args) {
        
        int[] fibs = calcFibIndexes40to45();
        System.out.println("\t\t\t\t\t\t40    41    42    43    44    45");
        System.out.println("---------------------------------------------------------");
        System.out.print("Listing 22.3 GCD\t\t");
        for (int i = 0; i < fibs.length - 1; i++) {
            long startTime = System.currentTimeMillis();
            int gcd = gcd(fibs[i], fibs[i + 1]);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.print("   " + executionTime);
        }
        System.out.print("\nListing 22.4 GCDEuclid ");
        for (int i = 0; i < fibs.length - 1; i++) {
            long startTime = System.currentTimeMillis();
            int gcd = gcdEuclid(fibs[i], fibs[i + 1]);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.print("     " + executionTime);
        }
    }

    
    public static int gcdEuclid(int m, int n) {
        if (m % n == 0)
            return n;
        else
            return gcdEuclid(n, m % n);
    }


    
    public static int gcd(int m, int n) {
        int gcd = 1;
        if (m % n == 0) return n;
        for (int k = n / 2; k >= 1; k--) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }

        return gcd;
    }


    private static int[] calcFibIndexes40to45() {
        int[] fibs = new int[6];
        int i = 2;
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        
        while (i < 40) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
            i++;
        }
        
        for (int j = 0; j < fibs.length; j++) {
            f2 = f0 + f1;
            fibs[j] = f2;
            f0 = f1;
            f1 = f2;
        }

        return fibs;
    }


}
