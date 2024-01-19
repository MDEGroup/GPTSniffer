

import java.util.Arrays;


public class MyString2{
    public static void main(String[] args) {
        MyString2 myString21 = new MyString2("Supercalifrajaliscousexpialidocious");
        MyString2 myString22 = new MyString2("abcdefghijklmnopqrstuvwxyz");
        String s = "abcdefghijklmnopqrstuvwxyz";
        MyString2 myString113 = new MyString2("HelloWorldWorldHelloWorld");
        MyString2 myString4 = new MyString2("MILO");
        MyString2 myString5 = new MyString2("SimonAndGarfunkel");
        System.out.println(Arrays.toString(myString4.toUpperCase().chars));
        System.out.println(myString22.compare(s));
        System.out.println(myString21.compare("SomeRandomString"));
        System.out.println(Arrays.toString(myString113.substring(3).chars));
        System.out.println(Arrays.toString(myString5.toChars()));
    }
}
