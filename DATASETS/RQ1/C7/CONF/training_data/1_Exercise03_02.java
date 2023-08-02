



public class IntegerSum{

    public static void main(String[] args) {

        int a = (int) (System.currentTimeMillis() % 10);
        int b = (int) (System.currentTimeMillis() / 7 % 10);
        int c = (int) (System.currentTimeMillis() / 5 % 10);

        int correctAnswer = a + b + c;


        Scanner input = new Scanner(System.in);

        System.out.print("Fill in your answer and then press enter: " + a + " + " + b + " + " + c + " = ");

        int userAnswer = input.nextInt();

        if (userAnswer == correctAnswer) {
            System.out.println("Congrats! That is correct!");
        } else
            System.out.println("That is incorrect, please try again");


    }

}
