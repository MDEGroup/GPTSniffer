


public class Exercise10_27 {
    public static void main(String[] args) {
        MyStringBuilder1 stringBuilder1 = new MyStringBuilder1("SOMESTRINGTESTHERE");
        System.out.println(stringBuilder1.toLowerCase().toString());
        System.out.println(stringBuilder1.length());
        MyStringBuilder1 stringBuilder3 = stringBuilder1.append(12);
        System.out.println(stringBuilder1.toString());
        System.out.println(stringBuilder3.toString());
        MyStringBuilder1 stringBuilder2 = new MyStringBuilder1("AddedSomeStringhere");
        stringBuilder1.append(stringBuilder2);
        System.out.println(stringBuilder1.toString());
        System.out.println(stringBuilder1.substring(3,11));

    }
}
