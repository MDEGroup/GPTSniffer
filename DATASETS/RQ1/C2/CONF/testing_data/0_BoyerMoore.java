 public class BoyerMoore {
    private final int R;     // the radix
    private int[] right;     // the bad-character skip array
    private char[] pattern;  // the pattern string

    // Constructor
    public BoyerMoore(String pattern) {
        this.R = 256;
        this.pattern = pattern.toCharArray();

        // Compute bad-character skip array
        int m = pattern.length();
        right = new int[R];
        for (int i = 0; i < R; i++)
            right[i] = -1;
        for (int j = 0; j < m; j++)
            right[pattern[j]] = j;
    }

    // Boyer-Moore search method
    public int search(String text) {
        int n = text.length();
        int m = pattern.length;
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern[j] != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i;    // match found
        }
        return -1;   // no match found
    }

    // Example usage
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";
        String pattern = "fox";
        BoyerMoore bm = new BoyerMoore(pattern);
        int index = bm.search(text);
        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}


