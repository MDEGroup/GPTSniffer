public class DivisibleByFiveOrSix {
    public static void main(String[] args) {
        final int NUMS_PER_LINE = 10;
        int count = 0;

        for (int i = 100; i <= 200; i++) {
            if ((i % 5 == 0 || i % 6 == 0) && !(i % 5 == 0 && i % 6 == 0)) {
                System.out.print(i + " ");
                count++;

                if (count == NUMS_PER_LINE) {
                    System.out.println();
                    count = 0;
                }
            }
        }
    }
}