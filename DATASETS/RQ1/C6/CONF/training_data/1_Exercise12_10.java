

import java.util.Stack;


public class OutOfMemoryExample{
    public static void main(String[] args) throws Exception {
        try {
            long[] testHeap = new long[50];
            for (int loop = 0; ; loop++) {
                testHeap = new long[testHeap.length * 4]; 
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error: " + e);
        }
    }
}