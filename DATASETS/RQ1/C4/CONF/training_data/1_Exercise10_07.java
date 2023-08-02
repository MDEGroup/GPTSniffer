

import java.util.Scanner;

import ch_09.exercise09_07.Account;


public class Exercise10_07 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Account[] atmAccounts = new Account[10];

        for (int i = 0; i < atmAccounts.length; i++) {

            atmAccounts[i] = new Account(i, 100.00);

        }
        LOOP:
        for (; ; ) { 

            System.out.print("Please enter an account ID#: ");


            int idOfAcc = input.nextInt();
            if (idOfAcc == 1234) {
                break;
            }

            while (idOfAcc < 0 | idOfAcc > 9) {

                System.out.println("Incorrect ID# please enter a correct ID# ");

                idOfAcc = input.nextInt();
                if (idOfAcc == 1234) {
                    break LOOP;
                }
            }


            int userInput = 0;

            while (userInput != 4) {


                System.out.println("Main Menu");
                System.out.println("1: Check Balance");
                System.out.println("2: Withdraw");
                System.out.println("3: Deposit");
                System.out.println("4: Exit");
                System.out.print("Enter a choice now:");

                userInput = input.nextInt();
                executeCommand(userInput, idOfAcc, input, atmAccounts);

            }
        }
    }

    public static void executeCommand(int userCommand, int accId,
                                      Scanner j, Account[] arr) {

        switch (userCommand) {

            case 1:
                System.out.printf("The balance in account " + accId + " is $%.2f \n",
                        arr[accId].getBalance());
                break;

            case 2:
                System.out.print("Enter the amount you want to withdraw:");
                arr[accId].withdraw(j.nextDouble());
                break;

            case 3:
                System.out.print("Enter the amount you you want to deposit:");
                arr[accId].deposit(j.nextDouble());


        }

    }

}
