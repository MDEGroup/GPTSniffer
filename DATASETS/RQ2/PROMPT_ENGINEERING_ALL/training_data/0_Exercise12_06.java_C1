public static int hex2Dec(String hexString) throws NumberFormatException {
    // Check that the input string is not null or empty
    if (hexString == null || hexString.isEmpty()) {
        throw new NumberFormatException("Input string is null or empty");
    }
    
    // Check that the input string contains only hexadecimal digits
    for (int i = 0; i < hexString.length(); i++) {
        char c = hexString.charAt(i);
        if (!Character.isDigit(c) && !("ABCDEFabcdef".indexOf(c) >= 0)) {
            throw new NumberFormatException("Input string is not a hex string");
        }
    }
    
    // Convert the input string to decimal
    int decimal = 0;
    for (int i = 0; i < hexString.length(); i++) {
        char c = hexString.charAt(i);
        int digit = Character.digit(c, 16);
        decimal = decimal * 16 + digit;
    }
    
    return decimal;
}