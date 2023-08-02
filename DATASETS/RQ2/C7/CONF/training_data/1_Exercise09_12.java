





public class DisplayIntersectPoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter four endpoints for two lines: x1, y1, x2, y2, x3, y3, x4, y4: ");

        double[] nums = new double[8];
        for (int i = 0; i < 8; i++) {
            nums[i] = in.nextDouble();
        }
        double a = nums[1] - nums[3];
        double b = -(nums[0] - nums[2]);
        double c = nums[5] - nums[7];
        double d = -(nums[4] - nums[6]);
        double e = (nums[1] - nums[3]) * nums[0] - (nums[0] - nums[2]) * nums[1];
        double f = (nums[5] - nums[7]) * nums[4] - (nums[4] - nums[6]) * nums[5];

        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);

        if (linearEquation.isSolvable()) {
            System.out.printf("The intersecting point is at (%.2f, %.2f)", linearEquation.getX(),
                    linearEquation.getY());

        } else {
            System.out.println("The equation does not have a solution with the points provided.");


        }
    }
}
