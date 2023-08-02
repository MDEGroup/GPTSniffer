



public class TestIdenticalArrays{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] one = new int[3][3];
        System.out.print("Enter list1: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                one[i][j] = in.nextInt();
            }
        }
        int[][] two = new int[3][3];
        System.out.print("\nEnter list2:  ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                two[i][j] = in.nextInt();
            }
        }
        if (equals(one, two)) {
            System.out.println("The arrays are identical.");
        } else {
            System.out.println("The arrays are not identical.");
        }
    }

    public static boolean equals(int[][] m1, int[][] m2) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
