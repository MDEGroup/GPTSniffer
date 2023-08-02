



public class HeadsAndTails{
    char[] coins = new char[9];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 511: ");
        int userNum = input.nextInt();
        String binStr = Integer.toBinaryString(userNum);
        HeadsAndTailsobj = new Exercise08_11();
        obj.handleCoins(binStr);
        input.close();
    }

    void handleCoins(String binStr) {
        String zerosStr = "";
        int zeros = 9 - binStr.length();

        for (int i = 1; i <= zeros; i++) {
            zerosStr += "0";
        }
        String completeBinStr = zerosStr.concat(binStr);
        System.out.println(completeBinStr);

        for (int i = 0; i < 9; i++) {

            coins[i] = completeBinStr.charAt(i);
        }
        for (int i = 0, j = 1; i < 9; i++, j++) {
            String str = String.valueOf(coins[i]);
            System.out.print(str.contentEquals("1") ? "T" : "H");
            if (j % 3 == 0) {
                System.out.println();
            }

        }

    }
}
