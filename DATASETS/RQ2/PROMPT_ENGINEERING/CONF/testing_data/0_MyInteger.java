public class MyInteger {
    private int value;

    public MyInteger(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isEven() {
        if (this.value % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOdd() {
        if (this.value % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPrime() {
        if (this.value <= 1) {
            return false;
        }
        for (int i = 2; i < this.value; i++) {
            if (this.value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(int val) {
        if (val % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOdd(int val) {
        if (val % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrime(int val) {
        if (val <= 1) {
            return false;
        }
        for (int i = 2; i < val; i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger myInt) {
        return myInt.isEven();
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.isOdd();
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }

    public boolean equals(int val) {
        if (this.value == val) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(MyInteger myInt) {
        return this.value == myInt.getValue();
    }

    public static int parseInt(char[] chars) {
        String str = new String(chars);
        return Integer.parseInt(str);
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}

public class TestMyInteger {
    public static void main(String[] args) {
        MyInteger myInt = new MyInteger(7);

        System.out.println("Value: " + myInt.getValue());
        System.out.println("Is even: " + myInt.isEven());
        System.out.println("Is odd: " + myInt.isOdd());
        System.out.println("Is prime: " + myInt.isPrime());

        System.out.println("Is 13 even: " + MyInteger.isEven(13));
        System.out.println("Is 13 odd: " + MyInteger.isOdd(13));
        System.out.println("Is 13 prime: " + MyInteger.isPrime(13));

        MyInteger anotherInt = new MyInteger(5);
        System.out.println("Is anotherInt even: " + MyInteger.isEven(anotherInt));
        System.out.println("Is anotherInt odd: " + MyInteger.isOdd(anotherInt));
        System.out.println("Is anotherInt prime: " + MyInteger.isPrime(anotherInt));

        System.out.println("Is equal to 7: " + myInt.equals(7));
        System.out.println("Is equal to anotherInt: " + myInt.equals(anotherInt));

        char[] numChars = {'1', '2', '3'};
        System.out.println("Parse int from char array: " + MyInteger.parseInt(numChars));

        String numString = "456";
        System.out.println("Parse int from string: " + MyInteger.parseInt(numString));
    }
}