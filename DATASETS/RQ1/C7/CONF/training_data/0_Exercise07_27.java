public static boolean equals(int[] list1, int[] list2) {
    if (list1.length != list2.length) {
        return false;
    }
    Arrays.sort(list1);
    Arrays.sort(list2);
    for (int i = 0; i < list1.length; i++) {
        if (list1[i] != list2[i]) {
            return false;
        }
    }
    return true;
}
 import java.util.Arrays;

public class IdenticalArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter list1: ");
        int[] list1 = readArray(input);

        
        System.out.print("Enter list2: ");
        int[] list2 = readArray(input);

        
        if (equals(list1, list2)) {
            System.out.println("Two lists are identical");
        } else {
            System.out.println("Two lists are not identical");
        }
    }

    
    public static int[] readArray(Scanner input) {
        int length = input.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }

    
    public static boolean equals(int[] list1, int[] list2) {
        if (list1.length != list2.length) {
            return false;
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }
        return true;
    }
}
