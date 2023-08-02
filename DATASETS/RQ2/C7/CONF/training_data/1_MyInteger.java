







public class MyInteger {

    private int value;

    public MyInteger(int newValue) {

        this.value = newValue;

    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {

        if (value % 2 == 0)
            return true;
        else
            return false;

    }

    public boolean isOdd() {
        if (value % 2 != 0)
            return true;
        else
            return false;

    }

    public boolean isPrime() {
        boolean prime = false;
        for (int i = 3; i < value / 2; i++) {
            if (value % i == 0) {
                prime = false;
            } else {
                prime = true;
                break;
            }
        }

        return prime;
    }

    public static boolean isEven(int a) {
        if (a % 2 == 0)
            return true;
        else
            return false;

    }

    public static boolean isOdd(int a) {
        if (a % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrime(int a) {
        boolean wellisIt = false;

        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) {
                wellisIt = false;
            } else {
                wellisIt = true;
            }

        }

        return wellisIt;

    }

    public static boolean isEven(MyInteger a) {
        return a.isEven();

    }

    public static boolean isOdd(MyInteger a) {
        return a.isOdd();
    }

    public static boolean isPrime(MyInteger a) {
        return a.isPrime();
    }

    public boolean equals(int a) {
        if (this.value == a) {
            return true;
        } else
            return false;
    }

    public boolean equals(Integer a) {
        if (this.value == a) {
            return true;
        } else {
            return false;
        }
    }

    public static int parseInt(char[] arr) {

        String str = String.valueOf(arr);

        int result = 0;

        for (int j = 0; j < str.length(); j++) {

            result += str.charAt(j);
        }

        return result;

    }

    public static int parseInt(String a) {

        return Integer.parseInt(a);

    }

}
