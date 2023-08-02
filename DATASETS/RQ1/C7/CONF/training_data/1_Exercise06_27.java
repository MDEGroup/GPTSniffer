


public class EmirpCalculator{
    public static void main(String[] args) {
        int count = 1;
        int i = 2;
        while (count <= 100) {
            if (isEmips(i)) {
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
                count++;
            }

            ++i;
        }
    }

    private static boolean isEmips(int n) {
        if (isPrime(n)) {
            String s = String.valueOf(n);
            if (checkPalindrome(s)) {
                return false;
            } else {
                String result = "";
                for (int i = s.length() - 1; i >= 0; i--) {
                    result += s.charAt(i);
                }
                int revNum = Integer.parseInt(result);
                return isPrime(revNum);
            }
        }
        return false;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkPalindrome(String num) {
        for (int i = 0, j = num.length() - 1; i < num.length() / 2; i++, j--) {
            if (num.charAt(i) != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
