



public class CheckList{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter list: ");
        int[] nums = new int[in.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        if (isSorted(nums)) {
            System.out.println("The list is sorted");

        } else {
            System.out.println("The list is not sorted");

        }
    }

    public static boolean isSorted(int[] list) {
        boolean sorted = true;
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    sorted = false;
                    break;
                }

            }
        }
        return sorted;
    }

}
