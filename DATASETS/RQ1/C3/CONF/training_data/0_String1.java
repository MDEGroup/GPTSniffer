public static boolean[] checkStringEndings(String[][] a, char[] c) {
    boolean[] b = new boolean[a.length];
    for (int i = 0; i < a.length; i++) {
        boolean rowEndsWithChar = true;
        for (int j = 0; j < a[i].length; j++) {
            if (!a[i][j].endsWith(Character.toString(c[i]))) {
                rowEndsWithChar = false;
                break;
            }
        }
        b[i] = rowEndsWithChar;
    }
    return b;
}
