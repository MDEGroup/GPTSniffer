package ch_12.exercise12_08;


public class Exercise12_08 {
    public static void main(String[] args) {
        String validHexString = "A7C9";
        String invalidHexString = "A7CZ";

        System.out.println("Hex String convert to decimal: " + hexToDecimal(validHexString));
        System.out.println("Hex String convert to decimal: " + hexToDecimal(invalidHexString));

    }

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;

        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if (checkHexChar(hexChar)) {
                decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
            } else {
                throw new HexFormatException(hex);
            }

        }
        return decimalValue;
    }

    static boolean checkHexChar(char ch) {
        return ch >= '0' && ch <= 'F';
    }

    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else { // ch is '0', '1', ..., or '9'
            return ch - '0';
        }
    }
}
