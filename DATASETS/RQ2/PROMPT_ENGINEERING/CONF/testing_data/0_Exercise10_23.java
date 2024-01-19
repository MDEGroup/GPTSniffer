public class MyString2 {
    private String str;

    public MyString2(String s) {
        this.str = s;
    }

    public int compare(String s) {
        int length1 = this.str.length();
        int length2 = s.length();
        
        if (length1 < length2) {
            return -1;
        } else if (length1 > length2) {
            return 1;
        } else {
            for (int i = 0; i < length1; i++) {
                if (this.str.charAt(i) < s.charAt(i)) {
                    return -1;
                } else if (this.str.charAt(i) > s.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public MyString2 substring(int begin) {
        if (begin < 0 || begin >= this.str.length()) {
            return new MyString2("");
        }
        
        String newStr = this.str.substring(begin);
        return new MyString2(newStr);
    }

    public MyString2 toUpperCase() {
        String upperCaseStr = this.str.toUpperCase();
        return new MyString2(upperCaseStr);
    }

    public char[] toChars() {
        char[] charArray = new char[this.str.length()];
        for (int i = 0; i < this.str.length(); i++) {
            charArray[i] = this.str.charAt(i);
        }
        return charArray;
    }

    public static MyString2 valueOf(boolean b) {
        if (b) {
            return new MyString2("true");
        } else {
            return new MyString2("false");
        }
    }
}
