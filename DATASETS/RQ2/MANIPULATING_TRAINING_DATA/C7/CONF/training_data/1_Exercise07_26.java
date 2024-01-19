



public class CompareArray {
    public static boolean equals(int[] list1, int[] list2) {

        boolean equalorNot = true;

        if (list1.length != list2.length)
            equalorNot = false;

        for (int i = 0; i < list1.length; i++) {

            if (list1[i] != list2[i])
                equalorNot = false;

        }
        return equalorNot;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1: (where the first integer represents the length of the list) ");

        int length = input.nextInt();

        int[] list1 = new int[length];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = input.nextInt();
        }
        System.out.println("Enter list2: (where the first integer represents the length of the list) ");

        int[] list2 = new int[input.nextInt()];

        for (int i = 0; i < list2.length; i++) {

            list2[i] = input.nextInt();
        }

        if (equals(list1, list2)) {
            System.out.println("The lists are strictly identical");
        } else {
            System.out.println("The lists are NOT strictly identical");
        }

    }

}
