public class MyStringBuilder1 {
    private char[] value;
    private int count;

    public MyStringBuilder1(String s) {
        value = s.toCharArray();
        count = value.length;
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        char[] newValue = new char[count + s.count];
        System.arraycopy(value, 0, newValue, 0, count);
        System.arraycopy(s.value, 0, newValue, count, s.count);
        count += s.count;
        value = newValue;
        return this;
    }

    public MyStringBuilder1 append(int i) {
        return append(String.valueOf(i));
    }

    public int length() {
        return count;
    }

    public char charAt(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return value[index];
    }

    public MyStringBuilder1 toLowerCase() {
        MyStringBuilder1 sb = new MyStringBuilder1("");
        for (int i = 0; i < count; i++) {
            sb.append(Character.toLowerCase(value[i]));
        }
        return sb;
    }

    public MyStringBuilder1 substring(int begin, int end) {
        if (begin < 0 || end > count || begin > end) {
            throw new IndexOutOfBoundsException();
        }
        char[] newValue = new char[end - begin];
        System.arraycopy(value, begin, newValue, 0, end - begin);
        return new MyStringBuilder1(new String(newValue));
    }

    public String toString() {
        return new String(value, 0, count);
    }
}
