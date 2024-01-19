

import java.util.Scanner;
import java.util.ArrayList;


public class nan{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> testList = new ArrayList<>();

        System.out.println("Enter ten integers to put into the list now:");

        for (int i = 0; i < 10; i++) {
            testList.add(input.nextInt());
        }

        removeDuplicate(testList);


        System.out.print("The distinct integers are ");
        for (Integer integer : testList) {
            System.out.print(integer + " ");
        }
        input.close();
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        Integer temp;
        for (int i = 0; i < list.size(); i++) {

            temp = list.get(i);

            list.remove(i);

            while (list.contains(temp)) {

                list.remove(temp);
            }

            list.add(i, temp);

        }


    }
}
