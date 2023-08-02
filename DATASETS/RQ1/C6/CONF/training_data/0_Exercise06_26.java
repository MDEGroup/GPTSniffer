public class PalindromicPrime {

    public static void main(String[] args) {
        int count = 0;
        int num = 2;
        while (count < 100) {
            if (isPrime(num) && isPalindromic(num)) {
                System.out.print(num + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            num++;
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(int num) {
        String str = Integer.toString(num);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}