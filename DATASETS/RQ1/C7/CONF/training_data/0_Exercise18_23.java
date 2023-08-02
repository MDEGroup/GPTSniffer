public static int bin2Dec(String binaryString) {
    
    if (binaryString.isEmpty()) {
        return 0;
    }
    
    int restValue = bin2Dec(binaryString.substring(1));
    
    int currentValue = binaryString.charAt(0) == '1' ? 1 : 0;
    return currentValue + 2 * restValue;
}
