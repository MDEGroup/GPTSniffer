import java.util.Scanner;

public class DeleteWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the word to be deleted: ");
        String wordToDelete = scanner.nextLine();

        String[] words = input.split(" ");
        StringBuilder newString = new StringBuilder();
        for (String word : words) {
            if (!word.equals(wordToDelete)) {
                newString.append(word + " ");
            }
        }

        System.out.println("String after deleting the word: " + newString);
    }
}

