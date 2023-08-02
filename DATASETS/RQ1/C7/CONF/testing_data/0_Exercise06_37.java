public static String format(int number, int width) {
    String numString = Integer.toString(number);
    int numZeroes = width - numString.length();
    if (numZeroes <= 0) {
        return numString;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numZeroes; i++) {
        sb.append('0');
    }
    sb.append(numString);
    return sb.toString();
}
