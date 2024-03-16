



public class NumberGenerator {
    public static void main(String[] args) {
        ArrayList<Integer> guesses = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        while (answer != number1 + number2) {

            if (guesses.contains(answer)) {
                System.out.println("You've already entered " + answer);
                System.out.print("Try again. What is " + number1 + " + " + number2 + "? ");
                answer = input.nextInt();

            } else {
                guesses.add(answer);
                System.out.print("Wrong answer. Try again. What is " + number1 + " + " + number2 + "? ");
                answer = input.nextInt();
            }

        }

        input.close();
        System.out.println("You got it!");
    }

}
