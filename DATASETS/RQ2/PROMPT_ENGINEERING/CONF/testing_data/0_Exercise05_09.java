import java.util.Scanner;

public class TopTwoStudents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String topStudent = "";
        double topScore = Double.MIN_VALUE;
        String secondTopStudent = "";
        double secondTopScore = Double.MIN_VALUE;

        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter student " + i + "'s name: ");
            String studentName = scanner.next();

            System.out.print("Enter student " + i + "'s score: ");
            double studentScore = scanner.nextDouble();

            if (studentScore > topScore) {
                secondTopScore = topScore;
                secondTopStudent = topStudent;
                topScore = studentScore;
                topStudent = studentName;
            } else if (studentScore > secondTopScore) {
                secondTopScore = studentScore;
                secondTopStudent = studentName;
            }
        }

        System.out.println("Top student: " + topStudent + " with score " + topScore);
        System.out.println("Second top student: " + secondTopStudent + " with score " + secondTopScore);
    }
}