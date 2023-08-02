public static int gcd(int... numbers) {
    int result = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
        result = gcd(result, numbers[i]);
    }
    return result;
}

private static int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}
