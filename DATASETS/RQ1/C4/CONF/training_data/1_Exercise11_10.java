

import java.util.Scanner;









public class Exercise11_10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MyStack testStack = new MyStack();

        do {

            System.out.print("Enter a string to place onto the stack:");
            testStack.push(input.nextLine());


        } while (testStack.getSize() < 5);

        System.out.println();

        while (!testStack.isEmpty()) {

            System.out.println(testStack.pop());

        }


        input.close();
    }
}
