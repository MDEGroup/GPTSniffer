



public class CustomString {
    public static void main(String[] args) {
        MyString1 myString11 = new MyString1(new char[]{'T', 'E', 'S', 'T', '1'});
        MyString1 myString12 = new MyString1(new char[]{'T', 'E', 'S', 'T', '1'});

        MyString1 myString13 = new MyString1(new char[]{'T', 'E', 'S', 'T', '2'});
        System.out.println(" MyString1 myString11 = new MyString1(new char[]{'T', 'E', 'S', 'T', '1'});\n" +
                "MyString1 myString12 = new MyString1(new char[]{'T', 'E', 'S', 'T', '1'});\n" +
                "MyString1 myString13 = new MyString1(new char[]{'T', 'E', 'S', 'T', '2'});\n");
        System.out.println("myString11.equals(myString12): " + myString11.equals(myString12));
        System.out.println("myString11.equals(myString13): " + myString11.equals(myString13));
        System.out.println("myString11.substring(1, 3).chars: " + Arrays.toString(myString11.substring(1, 3).chars));
        System.out.println("myString13.charAt(2): " + myString13.charAt(2));
        System.out.println("MyString1.valueOf(7).chars: " + Arrays.toString(MyString1.valueOf(7).chars));
        System.out.println("myString12.toLowerCase().chars " + Arrays.toString(myString12.toLowerCase().chars));
        System.out.println("myString11.length(): " + myString11.length());

    }
}
