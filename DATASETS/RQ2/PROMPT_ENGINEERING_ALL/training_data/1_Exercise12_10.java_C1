package ch_12;

import java.util.Stack;


public class Exercise12_10 {
    public static void main(String[] args) throws Exception {
        try {
            long[] testHeap = new long[50];
            for (int loop = 0; ; loop++) {
                testHeap = new long[testHeap.length * 4]; //Indefinitely increase array size inside of loop
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error: " + e);
        }
    }
}