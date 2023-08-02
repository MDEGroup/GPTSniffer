

import java.util.Random;
import java.util.Scanner;


public class ScissorRockPaperGame{

    public static void main(String[] args) {

        final int scissor = 0;
        final int rock = 1;
        final int paper = 2;

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Scissor (0), rock (1), paper (2): ");

        int user = in.nextInt();

        if (user == 0 || user == 1 || user == 2) {

            int comp = random.nextInt(3);
            String res = "The computer is";
            switch (user) {
                case 0:
                    if (comp == scissor) {
                        res += " scissor and you are scissor, it's a draw.";
                    } else if (comp == rock) {
                        res += " rock and you are scissor, you lost.";
                    } else if (comp == paper) {
                        res += " paper and you are scissor, you won.";
                    }
                    break;
                case 1:
                    if (comp == scissor) {
                        res += " scissor and you are rock, you won.";
                    } else if (comp == rock) {
                        res += " rock and you are rock, its a draw.";
                    } else if (comp == paper) {
                        res += " paper and you are rock, you lost.";
                    }
                    break;
                case 2:
                    if (comp == scissor) {
                        res += " scissor and you are paper, you lost.";
                    } else if (comp == rock) {
                        res += " rock and you are paper, you won.";
                    } else if (comp == paper) {
                        res += " paper and you are paper, it's a draw.";
                    }
                    break;

            }
            System.out.println(res);

        } else {
            System.out.println("Computer wins, you input an invalid value so you forfiet this round!");
        }

        in.close();
    }

}
