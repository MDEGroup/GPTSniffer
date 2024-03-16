import java.io.*;import java.util.Scanner;public class BitViewer {    public static void main(String[] args) {        Scanner input = new Scanner(System.in);        System.out.print("Please enter a file name: ");        String fileName = input.nextLine();        try {            FileInputStream fileInputStream = new FileInputStream(fileName);            int lastByte;            while ((lastByte = fileInputStream.read()) != -1) {                String binaryRepresentation = getBits(lastByte);                System.out.println("Binary representation of the last byte: " + binaryRepresentation);            }            fileInputStream.close();        } catch (FileNotFoundException e) {            System.err.println("File not found. Please check the file path and try again.");        } catch (IOException e) {            System.err.println("An error occurred while reading the file.");        }    }    public static String getBits(int value) {        StringBuilder binary = new StringBuilder(8);        for (int i = 7; i >= 0; i--) {            binary.append((value >> i) & 1);        }        return binary.toString();    }}