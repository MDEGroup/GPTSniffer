import java.util.*;

class Student {
    String name;
    int numCorrectAnswers;

    public Student(String name, int numCorrectAnswers) {
        this.name = name;
        this.numCorrectAnswers = numCorrectAnswers;
    }

    public int getNumCorrectAnswers() {
        return numCorrectAnswers;
    }

    @Override
    public String toString() {
        return name + " - " + numCorrectAnswers + " correct answers";
    }
}

public class SortStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 8));
        students.add(new Student("Bob", 6));
        students.add(new Student("Charlie", 9));
        students.add(new Student("Dave", 7));

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getNumCorrectAnswers(), s2.getNumCorrectAnswers());
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }
    }
}