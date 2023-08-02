
public class AssignGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        
        System.out.print("Enter " + numStudents + " scores: ");

        
        int[] scores = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            scores[i] = input.nextInt();
        }

        
        int best = scores[0];
        for (int i = 1; i < numStudents; i++) {
            if (scores[i] > best) {
                best = scores[i];
            }
        }

        
        for (int i = 0; i < numStudents; i++) {
            char grade;
            if (scores[i] >= best - 10) {
                grade = 'A';
            } else if (scores[i] >= best - 20) {
                grade = 'B';
            } else if (scores[i] >= best - 30) {
                grade = 'C';
            } else if (scores[i] >= best - 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grade);
        }
    }
}
