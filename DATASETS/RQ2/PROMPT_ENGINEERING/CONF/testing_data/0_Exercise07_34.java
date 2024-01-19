import java.util.Scanner;

public class SortingCharacters {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to sort: ");
        String userInput = input.nextLine();

        String sortedString = sort(userInput);
        System.out.println("Sorted string: " + sortedString);
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    swap(chars, j, j + 1);
                }
            }
        }

        return new String(chars);
    }

    public static void swap(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}