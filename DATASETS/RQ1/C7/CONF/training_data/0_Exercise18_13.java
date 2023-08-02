
public class LargestInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[8];
        
        System.out.print("Enter 8 integers: ");
        for (int i = 0; i < 8; i++) {
            array[i] = input.nextInt();
        }
        
        int max = findLargest(array, 0, array.length - 1);
        System.out.println("The largest integer in the array is: " + max);
    }
    
    public static int findLargest(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        } else {
            int mid = (left + right) / 2;
            int maxLeft = findLargest(array, left, mid);
            int maxRight = findLargest(array, mid + 1, right);
            return Math.max(maxLeft, maxRight);
        }
    }
}
