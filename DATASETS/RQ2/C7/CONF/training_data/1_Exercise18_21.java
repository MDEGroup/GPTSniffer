



public class DecimalConverter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal(base 10) number as an integer: ");
        int decValue = in.nextInt();
        System.out.println(decValue + " converted to binary is: " + dec2Bin(decValue));

        in.close();
    }

    public static String dec2Bin(int value) {
        return dec2Bin(value, "");
    }


    static String dec2Bin(int value, String binary) {
        if (value > 0) {
            return dec2Bin(value / 2, (value % 2) + binary);
        }
        return binary;
    }
}
