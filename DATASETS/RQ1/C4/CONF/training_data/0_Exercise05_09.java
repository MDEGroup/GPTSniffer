import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        
        String highestName = "";
        int highestScore = Integer.MIN_VALUE;
        String secondHighestName = "";
        int secondHighestScore = Integer.MIN_VALUE;

        
        for (int i = 0; i < numStudents; i++) {
            
            System.out.print("Enter the name and score of student " + (i + 1) + ": ");
            String name = input.next();
            int score = input.nextInt();

            
            if (score > highestScore) {
                secondHighestName = highestName;
                secondHighestScore = highestScore;
                highestName = name;
                highestScore = score;
            } else if (score > secondHighestScore) {
                secondHighestName = name;
                secondHighestScore = score;
            }
        }

        
        System.out.println("Student with the highest score: " + highestName + " (" + highestScore + ")");
        System.out.println("Student with the second-highest score: " + secondHighestName + " (" + secondHighestScore + ")");
    }
}
