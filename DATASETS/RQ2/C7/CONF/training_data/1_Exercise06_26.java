


public class PalindromicPrimeDisplayer {
    public static void main(String[] args) {
        int count = 1;
        int i = 2;
        while (count <= 100) {
            if (isPalindromicPrime(i)) {
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
                count++;
            }
            ++i;
        }
    }

    private static boolean isPalindromicPrime(int num) {
        boolean palPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                palPrime = false;
                break;
            }
        }
        if (palPrime) {
            return checkPalindrome(num);
        }
        return false;
    }

    static boolean checkPalindrome(int num) {
        String s = String.valueOf(num);
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
