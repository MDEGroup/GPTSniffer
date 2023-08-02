public class Main {
    public static int ternarySearch(int[] array, int x) {
        return ternarySearch(array, 0, array.length - 1, x);
    }

    public static int ternarySearch(int[] array, int left, int right, int x) {
        if (right >= left) {
            
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            
            if (array[mid1] == x) {
                return mid1;
            }
            
            if (array[mid2] == x) {
                return mid2;
            }
            
            if (array[mid1] > x) {
                return ternarySearch(array, left, mid1 - 1, x);
            }
            
            if (array[mid2] < x) {
                return ternarySearch(array, mid2 + 1, right, x);
            }
            
            return ternarySearch(array, mid1 + 1, mid2 - 1, x);
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 6;
        int result = ternarySearch(array, x);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
