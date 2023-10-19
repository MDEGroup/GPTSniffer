package ch_06;


public class Exercise06_30 {
    public static void main(String[] args) {
        int point = 0;
        System.out.println("Rolling dice.......");
        int rolled = roleDie1() + roleDie2();
        String res = checkResult(rolled);

        if (res.equalsIgnoreCase("craps")) {
            System.out.println("Craps!! Rolled a " + rolled + ". Better luck next time...");

        } else if (res.equalsIgnoreCase("point")) {
            point = rolled;
            System.out.println("Rolled " + rolled + ", point is established. Rolling again...");
            int rolling = 0;

            while (rolling != 7) {
                rolling = roleDie1() + roleDie2();
                System.out.println("You rolled a " + rolling);
                if (rolling == point) {
                    System.out.println("You Win!");
                    break;
                } else if (rolling == 7) {
                    System.out.println("You lose!");
                    break;
                }
            }

        } else if (res.equalsIgnoreCase("natural")) {
            System.out.println("Natural! You rolled a " + rolled + " you win!");
        }


    }

    static int roleDie1() {
        return (int) (1 + Math.random() * 7);
    }

    static int roleDie2() {
        return (int) (1 + Math.random() * 7);

    }

    static String checkResult(int roll) {
        if (roll == 2 || roll == 3 || roll == 12) {
            return "craps";
        } else if (roll == 7 || roll == 11) {
            return "natural";
        }
        return "point";

    }
}
