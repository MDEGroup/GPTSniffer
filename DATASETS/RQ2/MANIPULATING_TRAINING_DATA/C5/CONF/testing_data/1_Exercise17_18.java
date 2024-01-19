

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class BitConverter {
    static BufferedInputStream bufferedInputStream;
    static ArrayList<String> strBytes;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        strBytes = new ArrayList<>();
        System.out.println("Enter a filename: ");
        String fileName = in.nextLine().trim();
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
            int b;
            while ((b = bufferedInputStream.read()) != -1) {
                String val = getBits(b);
                strBytes.add(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The contents of the file, converted to bytes are: ");
        System.out.println(strBytes.toString());

        in.close();
    }

    public static String getBits(int value) {
        StringBuilder bits = new StringBuilder();
        long i;
        for (i = 128; i > 0; i /= 2) {
            bits.append((value & i) != 0 ? "1" : "0");
        }
        return bits.toString();
    }
}
