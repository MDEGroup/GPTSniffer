


public class DivisibleByFiveOrSix{
    public static void main(String[] args) {

        int count = 0;

        for (int i = 100; i <= 200; i++) {

            if (count == 10) {
                System.out.println();
                count = 0;
            }

            if (i % 5 == 0 ^ i % 6 == 0) {
                System.out.print(i + " ");
                count++;
            }


        }
    }
}
