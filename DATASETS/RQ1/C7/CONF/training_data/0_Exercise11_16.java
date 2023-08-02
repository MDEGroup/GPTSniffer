
public class RepeatAdditionQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<>();
        int num1 = (int)(Math.random() * 10);
        int num2 = (int)(Math.random() * 10);
        System.out.print("What is " + num1 + " + " + num2 + "? ");
        int answer = input.nextInt();
        while (num1 + num2 != answer) {
            if (answers.contains(answer)) {
                System.out.println("You already entered " + answer);
            } else {
                System.out.print("Wrong answer. Try again. What is " + num1 + " + " + num2 + "? ");
                answers.add(answer);
            }
            answer = input.nextInt();
        }
        System.out.println("You got it!");
    }
}
