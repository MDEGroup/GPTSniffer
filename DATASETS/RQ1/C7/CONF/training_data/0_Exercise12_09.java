public class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        if (!binaryString.matches("[01]+")) {
            throw new BinaryFormatException("Input is not a binary string");
        }
        int decimal = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            decimal = decimal * 2 + Character.getNumericValue(ch);
        }
        return decimal;
    }
}
