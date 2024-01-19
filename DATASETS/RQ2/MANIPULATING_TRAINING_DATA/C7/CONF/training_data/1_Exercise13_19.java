



public class PrintDecimalNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decVal = in.next();
        try {
            System.out.println("The fraction number is " + decimalToFraction(decVal));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        in.close();
    }

    private static String decimalToFraction(String val) throws Exception {
        boolean isNegative = val.startsWith("-");

        String[] decimalNumberParts = val.split("\\.");
        if (decimalNumberParts.length < 2) {
            throw new Exception("You must enter a decimal number like: 123.12");
        }
        if (val.startsWith("-")) {
            isNegative = true;
        }
        Rational leftSideOfDecimal = new Rational(Long.parseLong(decimalNumberParts[0]));
        String denominatorRightSide = "1";
        for (int i = 0; i < decimalNumberParts[1].length(); i++) {
            denominatorRightSide += "0";
        }
        Rational rightSideOfDecimal = new Rational(Long.parseLong(decimalNumberParts[1]), Long.parseLong(denominatorRightSide));
        Rational result = leftSideOfDecimal.add(rightSideOfDecimal);
        return (isNegative ? "-" : "") + result.toString();

    }
}
