package ch_04;

import javax.xml.soap.SAAJMetaFactory;
import java.util.*;


public class Exercise04_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a character: ");
        String s = in.next("[A-Za-z\\d]");
        char myChar = s.charAt(0);
        System.out.println("The Unicode for the character " + myChar + " is " + (int) myChar);
    }
}