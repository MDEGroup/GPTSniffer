



public class GradeGenerator{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of students now: ");
        final int numOfStudents = in.nextInt();
        int[] grades = new int[numOfStudents];

        System.out.println("Now enter " + numOfStudents + " space separated scores: ");

        for (int i = 0; i < numOfStudents; i++) {
            grades[i] = in.nextInt();
        }
        printLetterGrades(grades, findBestGrade(grades));

    }

    static void printLetterGrades(int[] grades, int bestGrade) {

        for (int j = 0; j < grades.length; j++) {
            char letterGrade;
            if (grades[j] >= (bestGrade - 10)) {
                letterGrade = 'A';
            } else if (grades[j] >= (bestGrade - 20)) {
                letterGrade = 'B';
            } else if (grades[j] >= (bestGrade - 30)) {
                letterGrade = 'C';
            } else if (grades[j] >= (bestGrade - 40)) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }
            System.out.println("Student " + j + " score is " + grades[j] + " and grade is " + letterGrade);
        }

    }

    static int findBestGrade(int[] grades) {
        int best = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > best) {
                best = grades[i];
            }
        }
        return best;
    }


}
